File newFile = new File(name + " " + i + ".txt");
        newFile.createNewFile();
        out = new FileOutputStream(newFile);
        out.write(b); // Writes to the file
        out.flush();
        out.close();