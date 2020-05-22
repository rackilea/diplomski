class HardwareId {
    public UUID read() {
        Preferences pref = Preferences.systemNodeForPackage(HardwareId.class);
        String uuid = pref.get("UUID", null);
        if (uuid == null) {
            uuid = UUID.randomUUID().toString();
            pref.put("UUID", uuid);
            pref.flush();
        }
        return UUID.fromString(uuid);
    }
}