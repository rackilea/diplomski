private int getSize(Object data) {
        int size = 0;
        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            ObjectOutputStream stream = new ObjectOutputStream(bout);
            stream.writeObject(data);
            stream.close();
            size = bout.size();
        } catch (IOException e) {
            System.err.println("error: " + e.getMessage());
        }
        return size;
    }