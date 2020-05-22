response.setContentType("multipart/x-mixed-replace;boundary=END");
ServletOutputStream out = response.getOutputStream();
out.println("--END");
for(File f:files){
      FileInputStream fis = new FileInputStream(file);
      BufferedInputStream fif = new BufferedInputStream(fis);
      int data = 0;
      out.println("--END");
      while ((data = fif.read()) != -1) {
        out.write(data);
      }
      fif.close();
      out.println("--END");
      out.flush();
}
out.flush();
out.println("--END--");
out.close();