@Override
public NdefMessage createNdefMessage(NfcEvent event) {
    try {
        Properties p = new Properties();

        p.setProperty(
                DevicePolicyManager.EXTRA_PROVISIONING_DEVICE_ADMIN_PACKAGE_NAME,
                "com.example.some.app");

        Properties extras = new Properties();
        extras.setProperty("Key1", "TestString1");
        extras.setProperty("Key2", "TestString2");
        StringWriter sw = new StringWriter();
        try{
            extras.store(sw, "admin extras bundle");
            p.put(DevicePolicyManager.EXTRA_PROVISIONING_ADMIN_EXTRAS_BUNDLE,
                    sw.toString());
            Log.d(TAG, "Admin extras bundle=" + p.get(
                    DevicePolicyManager.EXTRA_PROVISIONING_ADMIN_EXTRAS_BUNDLE));
        } catch (IOException e) {
            Log.e(TAG, "Unable to build admin extras bundle");
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        OutputStream out = new ObjectOutputStream(bos);
        p.store(out, "");
        final byte[] bytes = bos.toByteArray();

        NdefMessage msg = new NdefMessage(NdefRecord.createMime(
                DevicePolicyManager.MIME_TYPE_PROVISIONING_NFC, bytes));
        return msg;
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}