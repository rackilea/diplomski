ProcessBuilder pb = new ProcessBuilder("java", "-Xmx1024m", "-Xms1024m",
         "-DTOOLS_DIR=C://", "-Daoi=whole", 
         "-jar", "C://calc.jar");
try {
    pb.start();
} catch (IOException ex) {
    System.out.print("EEE"+ex);
}