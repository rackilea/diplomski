int index;
 byte[] buffer = new byte[2048];
 float[] floatBuffer = new float[1024];
 FastYin detector = new FastYin(44100,1024);
 public void message(byte[] b){
   for(int i = 0 ; i < b.length; i++){
     buffer[index] = b[i];
     index++
     if(index==2048){
       AudioFloatConverter converter = AudioFloatConverter.getConverter(new Format(16bits, little endian, mono,...));
       //converts the byte buffer to float
       converter.toFloatArray(buffer,floatBuffer);
       float pitch = detector.getPitch(floatBuffer);
       //here you have your pitch info that you can use
       index = 0;
     }
   }