try {
    String s = new String("Æàìáûë".getBytes(StandardCharsets.ISO_8859_1), "Windows-1251");
    Files.write(Paths.get("C:/cyrillic.txt"),
        ("\uFEFF" + s).getBytes(StandardCharsets.UTF_8));
} catch (IOException e) {
    e.printStackTrace();
}