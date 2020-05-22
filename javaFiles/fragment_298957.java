if (directory.exists()) {
    System.out.println("Directory already exists!");
} else {
    success = directory.mkdir();
    if (success) {
        System.out.println("Successful");
    } else {
        throw new IOException("can't make directory for " + s);
    }
}