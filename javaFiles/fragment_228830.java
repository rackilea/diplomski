try {
    PrintWriter writer = new PrintWriter(new File(getResource("save.txt").toURI()));

    writer.println("level:" + level);
    writer.println("coins:" + coins);

    writer.close();
} catch (FileNotFoundException | URISyntaxException e) {
    e.printStackTrace();
}