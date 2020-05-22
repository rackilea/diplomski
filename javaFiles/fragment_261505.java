MultipartEntity e = new MultipartEntity();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(yourserializableobject);
        oos.flush();
        oos.close();
        InputStreamBody isb = new InputStreamBody(new ByteArrayInputStream(baos.toByteArray()), "o");
        e.addPart("o", isb);