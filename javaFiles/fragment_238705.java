public static void main(String[] args) {
      String fileName = "sampleObjectFile.txt";
      SampleObject sampleObject = new SampleObject();
      File file = new File(fileName);
      file.setWritable(true); //make it writable.
      try(ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))){
           outputStream.writeObject(sampleObject);
           outputStream.close();
      } catch (IOException e) {
           e.printStackTrace();
      }
 }