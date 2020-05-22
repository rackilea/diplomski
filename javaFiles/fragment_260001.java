try (DataInputStream dis = new DataInputStream(
        new BufferedInputStream(
        new FileInputStream(file)))) {
    while (dis.available() != 0) {
        System.out.println(dis.readLine());
    }
} catch (IOException e) {
    e.printStackTrace();
}