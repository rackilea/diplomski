public static void main(String[] args) throws Exception{
  DataOutputStream dos=new DataOutputStream(new FileOutputStream("/path/to/your/file"));

  int nbDesiredBytes=99999999;
  int bufferSize=1024;
  byte[] buffer = new byte[bufferSize];
  Random r=new Random();

  int nbBytes=0;
  while(nbBytes<nbDesiredBytes){
    int nbBytesToWrite=Math.min(nbDesiredBytes-nbBytes,bufferSize);
    byte[] bytes=new byte[nbBytesToWrite];
    r.nextBytes(bytes);
    dos.write(bytes);
    nbBytes+=nbBytesToWrite;
  }

  dos.close();
}