public static void main(String[] args) {
      try {
          FileOutputStream fos = new FileOutputStream("f:/arhivaB.zip");
          ZipOutputStream zos = new ZipOutputStream(fos);

          Path calea = Paths.get("c:\\bin\\HOTTT.pdf");
          File fisa = calea.toFile();
          Path caleb = Paths.get("c:\\bin\\fisx.docx");
          File fisb = caleb.toFile();
          Path calec = Paths.get("c:\\bin\\fisx.xlsx");
          File fisc = calec.toFile();


          addToZipFile(fisa, zos);
          addToZipFile(fisb, zos);
          addToZipFile(fisc, zos);
//          addToZipFile(file1Name, zos);
//          addToZipFile(file2Name, zos);
//          addToZipFile(file3Name, zos);

          zos.close();
          fos.close();

      } catch (FileNotFoundException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }

  public static void addToZipFile(/*String fileName*/ File fisa, ZipOutputStream zos) throws FileNotFoundException, IOException {

//      System.out.println("Writing '" + fileName + "' to zip file");

//      File file = new File(fileName);
      FileInputStream fis = new FileInputStream(fisa);
      ZipEntry zipEntry = new ZipEntry(fisa.getName());
      zos.putNextEntry(zipEntry);

      byte[] bytes = new byte[1024];
      int length;
      while ((length = fis.read(bytes)) >= 0) {
          zos.write(bytes, 0, length);
      }

      zos.closeEntry();
      fis.close();
  }