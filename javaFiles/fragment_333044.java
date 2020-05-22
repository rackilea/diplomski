final Process pr = new ProcessBuilder(
    "java",
    "-Xms512M",
    "-Xmx1024M",
    "-jar",
    "minecraft_server.jar",
    "nogui")
    .directory(new File("minecraft")) //Set the working directory to ./minecraft/
    .start();