public void exportFile(String fileFormat) throws Exception{

//upper portion of Code

        File fileToOpen = new File("LocationOfFile");
        if(Desktop.isDesktopSupported()) {
            new Thread(() -> {
                try {
                    Desktop.getDesktop().open(fileToOpen);
                    System.out.println("FileOpened Successfully");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }


        System.out.println("exportFile finishing");
    }