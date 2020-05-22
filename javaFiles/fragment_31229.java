public static void initDirs() {
    String osName = Hardware.osName.toLowerCase();

    if(osName.contains("win")) {
        gameDir = new File((System.getenv("APPDATA") + File.separator + "Hidden" + File.separator));
    } else if(osName.contains("mac")) {
        gameDir = new File(System.getProperty("user.home") + "/Library/Application Support/Hidden"+File.separator);
    } else if(osName.contains("nux")) {
        gameDir = new File(System.getProperty("user.home"));
    }

    if(!gameDir.exists()) gameDir.mkdir();

     try {
        FileOutputStream fos = new FileOutputStream(gameDir + File.separator + fileName);
        ObjectOutputStream out = new ObjectOutputStream(fos);
        out.writeObject(object);
        out.close();
        fos.close();
        return true;
    } catch(Exception e) {
        e.printStackTrace();
        System.err.println("Couldn't save game.");
        return false;
    }
}