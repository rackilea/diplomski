public static void load(String n) {
    try {
        FileInputStream saveIn = new FileInputStream("saves/" + n + ".sav");
        try (ObjectInputStream loadObj = new ObjectInputStream(saveIn)) {
            Test.p1 = (Player) loadObj.readObject();
            Test.p2 = (Player) loadObj.readObject();
            Test.p3 = (Player) loadObj.readObject();
            Test.p4 = (Player) loadObj.readObject();
            Test.map = (ArrayList<Star>) loadObj.readObject();
        }
    } catch (IOException | ClassNotFoundException e) {
        Test.loadError.setVisible(true);
    }
}