while ((read = bis.read(bytesIn)) != -1) {
             zos.write(bytesIn, 0, read);
         }
         zos.closeEntry();
     } catch (IOException e) {
             //Take appropriate action
     }
 }