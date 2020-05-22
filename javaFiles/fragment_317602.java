// Check if a file exists 
        public boolean exists() throws IOException {
            boolean isExists = false;       
            try{
                FileSystem hdfs = FileSystem.get(new URI("hdfs://localhost:9000"),new Configuration());
                Path newPath = new Path("/test.txt");
                isExists = hdfs.exists(newPath);
                hdfs.close();           
            }catch(IOException ex){
                // log exception and then re-throw
                throw ex;
            }
            return isExists;
        }