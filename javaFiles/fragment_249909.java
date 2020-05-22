// Export again to test output
    Relation db2 = new Relation();

    importFromXml reader = new importFromXml();
    try {
        reader.ReadDbNow(db2);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    try {
        saver.SaveDbNow2(db2);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }