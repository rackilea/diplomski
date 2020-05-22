try {
            DistributedCache.addCacheFile(new URI(filename), job.getConfiguration());

        } catch (URISyntaxException e) {
            System.out.println("URI exception: "+filename);
            e.printStackTrace();
        }