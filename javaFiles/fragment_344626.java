@Override
protected void initClassDefaults(UIDefaults table) {
    super.initClassDefaults(table);
    String cName = NapkinLookAndFeel.class.getName();
    String basicPackageName = cName.replace("NapkinLookAndFeel", "Napkin");
    for (String uiType : UI_TYPES) {
        String uiClass = basicPackageName + uiType;
        table.put(uiType, uiClass);
    }

    Set<Object> keys = new HashSet<Object>(table.keySet());
    keys.removeAll(Arrays.asList(UI_TYPES));
    if (keys.size() != 0) {
        System.out.println("keys we didn't overwrite: " + keys);
    }
}