public static String getFileToSaveTo(Frame frame) {
        JFileChooser fc=new JFileChooser();
          int returnVal=fc.showOpenDialog(frame);
          if (returnVal == JFileChooser.APPROVE_OPTION) {
            return fc.getSelectedFile().getAbsolutePath();
          }
         else {
            return null;
          }
    }