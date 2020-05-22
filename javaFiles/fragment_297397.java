InputStream input = urlConnection.getInputStream();
            byte[] buffer = new byte[4096];
            int n = - 1;
            while ( (n = input.read(buffer)) != -1) 
            {
                stream.write(buffer, 0, n);
            }