public int countLines(BlobKey key) throws Exception {
          BlobstoreInputStream bsis = new BlobstoreInputStream(key);
          BufferedReader br = new BufferedReader(new InputStreamReader(bsis));

          int lineCount = 0;
          while ( br.readLine() != null ) 
                 lineCount++;

          return lineCount;
}