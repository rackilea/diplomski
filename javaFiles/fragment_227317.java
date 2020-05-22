File outFile = new File("output.data");
        FileOutputStream fStream;
        ObjectOutputStream oStream;
        try {
            if(!outFile.exists()) outFile.createNewFile();
            fStream = new FileOutputStream(outFile);
            oStream = new ObjectOutputStream(fStream);
            oStream.writeObject(fix);
            JOptionPane.showMessageDialog(null, "File written successfully");
            oStream.close();
        } catch (IOException e) {
            System.out.println(e);
        }