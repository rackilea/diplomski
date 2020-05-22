try {
    // Considering var1 = MainActivity2
    Class cls = Class.forName("package.name." + var1);
    Intent intent = new Intent(MainActivity.this, cls);
    startActivity(intent);
} catch (ClassNotFoundException e) {
    e.printStackTrace();
}