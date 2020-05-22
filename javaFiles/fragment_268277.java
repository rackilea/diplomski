OutputStream out = response.getOutputStream();
        File file = new File(path_to_a_file);
        response.setContentType(file_content_type);
        response.setHeader("Content-disposition","attachment; filename="+FILE_NAME);
        FileInputStream inputStream = new FileInputStream(FILE);
        //Read bytes and write until finished