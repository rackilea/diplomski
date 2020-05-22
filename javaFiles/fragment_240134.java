try
{
    Process process = Runtime.getRuntime().exec(new String[]{"lp", tempFileFullPath});
    process.waitFor();
} catch (Exception e) {
    // error handling
}