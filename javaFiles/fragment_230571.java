try {
        f1 = new File("sink.txt");
        f1.createNewFile();
        fw = new FileWriter(f1);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }