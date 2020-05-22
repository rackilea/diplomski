private void doFileUpload(){
     byte[] videoBytes;
     try {
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         FileInputStream fis = new FileInputStream(new File(selectedPath));

         byte[] buf = new byte[1024];
         int n;
         while (-1 != (n = fis.read(buf)))
             baos.write(buf, 0, n);

        String videoBytes = baos.toByteArray();


         video_str = Base64.encodeBytes(videoBytes);
            System.out.println("video array"+video_str);


    } catch (Exception e) {
        // TODO: handle exception
    }}