private static void uploadFile(Drive service, String originfolder) {
        try {
            java.io.File dir = new java.io.File(originfolder);
            String [] fileslist = dir.list();
            for (String file : fileslist) {
                System.out.println(file);
                File uploadfile = new File();
                uploadfile.setName(file);
                java.io.File filePath = new java.io.File(originfolder + file);
                FileContent mediaContent = new FileContent("image/jpeg", filePath);
                File uploadedfile = service.files().create(uploadfile, mediaContent)
                    .setFields("id")
                    .execute();
                System.out.println("File ID: " + file);
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }