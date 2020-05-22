Properties p = new Properties();
try (InputStream is = new FileInputStream(new File("Config.cfg"))) {
    p.load(is);

    String name = p.getProperty("name");
    int keyCode = Integer.parseInt(p.getProperty("keyCode"));
    int modifiers = Integer.parseInt(p.getProperty("modifiers"));

    KeyStroke ks = KeyStroke.getKeyStroke(keyCode, modifiers);
    System.out.println(ks);

} catch (IOException exp) {
    exp.printStackTrace();
}