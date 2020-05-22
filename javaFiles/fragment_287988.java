URL url = new URL(
            "https://docs.oracle.com/javase/tutorialJWS/samples/uiswing/WallpaperProject/Wallpaper.jnlp");

    // Downloading and starting the application...
    final File jnlp = File.createTempFile("temp", ".jnlp");

    try (InputStream is = url.openStream();
            FileOutputStream fos = new FileOutputStream(jnlp)) {
        byte[] buffer = new byte[8192];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }
    }

    System.out.println("JNLP file written to " + jnlp.getAbsolutePath());

    //Desktop.getDesktop().open(jnlp);
    new ProcessBuilder("cmd", "/c", "javaws", jnlp.getAbsolutePath())
            .start();