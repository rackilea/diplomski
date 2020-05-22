try (ObjectOutputStream os =
            new ObjectOutputStream(new FileOutputStream("myserial.ser"));) {
        os.writeObject(e1);
    } catch(IOException ioex) {
        ioex.printStackTrace();
    }