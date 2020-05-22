Map<String, Integer> keyTextToCode = new HashMap<String, Integer>(256);
Field[] fields = KeyEvent.class.getDeclaredFields();
for (Field field : fields) {
    String name = field.getName();
    if (name.startsWith("VK_")) {
        keyTextToCode.put(name.substring("VK_".length()).toUpperCase(),
                          field.getInt(null));
    }
}