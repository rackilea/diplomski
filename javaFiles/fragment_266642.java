Process process = null;
DataOutputStream dataOutputStream = null;

try {
    process = Runtime.getRuntime().exec("su");
    dataOutputStream = new DataOutputStream(process.getOutputStream());
    dataOutputStream.writeBytes("chmod 644 FilePath\n");
    dataOutputStream.writeBytes("exit\n");
    dataOutputStream.flush();
    process.waitFor();
} catch (Exception e) {
    return false;
} finally {
    try {
        if (dataOutputStream != null) {
            dataOutputStream.close();
        }
        process.destroy();
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}