try {
      URL url2 = new URL(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI().toString()+your path to file in structre);
      InputStream in = url2.openStream();
} catch (URISyntaxException ex) {
      Logger.getLogger(PrepareGUI.class.getName()).log(Level.SEVERE, null, ex);
}