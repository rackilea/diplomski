Process process = Runtime.getRuntime().exec(new String[] {
        "/bin/sh",
        "-c",
        "adb devices | tail -n +2 | cut -sf 1"
});
process.waitFor();