PrintWriter writer = null;
try {
    writer = new PrintWriter(fullPath, "UTF-8");
    writer.write("1");
} catch (IOException e) {
    Log.e(TAG + number, "Could not turn on", e);
}
finally {
    if(writer != null){
        try {
            writer.close();
        } catch (Exception e) {
            Log.e(TAG + number, "Could not close writer", e);
        }
    }
}