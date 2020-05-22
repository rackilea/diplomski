// Export again to test output
    Relation db2 = null;

    importFromXml reader = new importFromXml();
    try {
        db2 = reader.ReadDbNow();
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