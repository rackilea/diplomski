File f = new File(System.getProperty("user.home"), "test.ser");
Map<String, String> table1 = new HashMap<>();
table1.put("Hello", "world");
try (FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);) {
    oos.writeObject(table1);
} catch (Exception e) {
    e.printStackTrace();
}
try (FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);) {
    Map<String, String> table = (Map<String, String>) ois.readObject();
    System.out.println(table);
} catch (Exception e) {
    e.printStackTrace();
}