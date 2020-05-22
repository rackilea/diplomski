try {
        while (true)
            l.add((Lieu<Double,String>)ois.readObject());
    } catch (ClassNotFoundException | IOException e) {
        //Expecting a EOFException here
    } finally {
        try {
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }