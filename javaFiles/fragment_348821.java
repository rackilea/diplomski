File file = new File("FileToUse.txt");
FileInputStream fis = null;

    try {
        fis = new FileInputStream(file);

        System.out.println("Total file size to read (in bytes) : "
                + fis.available());

        int content;
        while ((content = fis.read()) != -1) {
            // process the content into the hashmap
        }

    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if (fis != null)
                fis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
}