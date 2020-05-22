try ( PrintWriter out = new PrintWriter(new FileWriter("TestFile.txt")) {
        newItemArea.write(out);
    } catch (IOException e1) {
        System.err.println("Error occurred");
        e1.printStackTrace();
    }