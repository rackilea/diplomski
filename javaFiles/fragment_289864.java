private static void writeCache(ObjectOutputStream oos,
        HashMap<String, BufferedImage> data) throws IOException {
    // Number of saved elements
    oos.writeInt(data.size());
    // Let's write (url, image) for each entry in the cache
    for (Entry<String, BufferedImage> entry : data.entrySet()) {
        oos.writeObject(new URL(entry.getKey()));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(entry.getValue(), "jpg", baos);
        byte[] bytes = baos.toByteArray();
        oos.writeObject(bytes);
    }
}

private static HashMap<String, BufferedImage> readCache(
        ObjectInputStream ois) throws IOException, ClassNotFoundException {
    // Number of saved elements
    int size = ois.readInt();
    // Cache
    HashMap<String, BufferedImage> result = new HashMap<>(size);
    // Let's read (url, image) and add them to cache
    for (int i = 0; i < size; i++) {
        String url = ((URL) ois.readObject()).toString(); // EXCEPTION HERE
        ByteArrayInputStream bais = new ByteArrayInputStream(
                (byte[]) ois.readObject());
        BufferedImage image = ImageIO.read(bais);
        result.put(url, image);
    }
    return result;
}