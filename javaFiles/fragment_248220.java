File f = new File("Path_to_PDF");
byte[] pdf = new byte [(int)f.length()];
FileInputStream fis = new FileInputStream(f);
BufferedInputStream bis = new BufferedInputStream(fis);
bis.read(pdf,0,pdf.length);
OutputStream os = s.getOutputStream();
os.write(pdf, 0, pdf.length);
os.flush();