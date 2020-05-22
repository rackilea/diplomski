BufferedWriter writer = null;
    try {
        writer = new BufferedWriter(new FileWriter("./output.txt"));
        writer.write("your data here");
    } catch (IOException e) {
        System.err.println(e);
    } finally {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }