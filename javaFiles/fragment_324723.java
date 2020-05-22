///
/// Tries to run a script in the background
///
try {
    Runtime rt = Runtime.getRuntime();
    Process pr = rt.exec("sh ./launcher.sh", new String[] {}, wrkDir);
    // pr.waitFor(); // Intentionally not using
} catch(Exception e) {
    throw new RuntimeException(e);
}