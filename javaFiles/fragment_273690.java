public static int parseKeycode(String keycode) {
    // We assume keycode is in the format VK_{KEY}
    Class keys = KeyEvent.class; // This is where all the keys are stored.
    Field key = keys.getDeclaredField(keycode); // Get the field by name.
    int keycode = key.get(null); // The VK_{KEY} fields are static, so we pass 'null' as the reflection accessor's instance.
    return keycode;
}