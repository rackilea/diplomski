File home = new File(System.getProperty("user.home"));

for (File file : home.listFiles()) {
    if (file.isDirectory()) {
        System.out.println(file);
    }
}