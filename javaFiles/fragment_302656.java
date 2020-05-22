public static void streamCopy(InputStream in, OutputStream out)
       throws IOException{

        byte[] data = new byte[1024];
        int length;
        do{
            length = in.read(data);
            if(length > 0){
                out.write(data, 0, length);
                out.flush();
            }
        }while(length != -1);

}