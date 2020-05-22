public static void main(String[] args) throws IOException,
                InterruptedException {
        String[] cmd = new String[] { "cmd.exe", "/C", "dir", "2>&1" };
        Process process = Runtime.getRuntime().exec(cmd);
        InputStream stdout = process.getInputStream();
        while( stdout.read() >= 0 ) { ; }
        process.waitFor();
    }
}