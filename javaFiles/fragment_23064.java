public void
read(String key, Path path) throws StorageException
    {
        GetObjectRequest request = new GetObjectRequest (bucket, key);

        for (int retries = 5; retries > 0; retries--) 
        try (S3Object s3Object = s3.getObject (request))
        {
            if (s3Object == null)
                return; // occurs if we set GetObjectRequest constraints that aren't satisfied

            try (OutputStream outputStream = Files.newOutputStream (path, WRITE, CREATE, TRUNCATE_EXISTING))
            {
                byte[] buffer = new byte [16_384];
                int bytesRead;
                while ((bytesRead = s3Object.getObjectContent().read (buffer)) > -1) {
                    outputStream.write (buffer, 0, bytesRead);
                }
            }
            catch (SocketException | SocketTimeoutException e)
            {
                // We retry exceptions that happen during the actual download
                // Errors that happen earlier are retried by AmazonHttpClient
                try { Thread.sleep (1000); } catch (InterruptedException i) { throw new StorageException (i); }
                log.log (Level.INFO, "Retrying...", e);
                continue;
            }
            catch (IOException e)
            {
                // There must have been a filesystem problem
                // We call `abort` to save bandwidth
                s3Object.getObjectContent().abort();
                throw new StorageException (e);
            }

            return; // Success
        }
        catch (AmazonClientException | IOException e)
        {
            // Either we couldn't connect to S3
            // or AmazonHttpClient ran out of retries
            // or s3Object.close() threw an exception
            throw new StorageException (e);
        }

        throw new StorageException ("Ran out of retries.");
    }