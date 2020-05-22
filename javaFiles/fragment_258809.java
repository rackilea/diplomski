public void test() {
    try(InputStream is = getClass().getResourceAsStream("Images/questionMark.png")) {
        ImageIO.read(is);
    } catch (IOException e) {
        e.printStackTrace();
    }
}