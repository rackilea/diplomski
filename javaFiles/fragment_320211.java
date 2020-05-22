try {
        File file = new File(context.getCacheDir() + File.separator + "Log.txt");

    if (!file.exists()) {
        file.createNewFile();
    }
} catch (Exception e) {
    Log.w("tun tun", e.toString());
}