try (InputStream is = new URL(url).openStream();
     FileOutputStream fos = new FileOutputStream(...)) {
    is.transferTo(fos);
} catch (IOException ex) {
    ex.printStackTrace();
}