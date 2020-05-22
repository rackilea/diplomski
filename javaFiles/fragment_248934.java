try {
    Desktop.getDesktop().mail(new URI(e.getURL() + ""));
} catch (IOException e1) {
    e1.printStackTrace();
} catch (URISyntaxException e1) {
    e1.printStackTrace();
}