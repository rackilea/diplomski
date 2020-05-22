JarFile file = null;

try {
    file = new JarFile("does/not/exist");
} catch (IOException e) {
    System.out.println(file); //Prints out null
}

try {
    file.close(); //Throws NullPointerException
} catch (IOException e) {
    e.printStackTrace();
}