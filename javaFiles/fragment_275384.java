String[] cmd = {
"/bin/sh",
"-c",
"ls /etc | grep release"
};

Process p = Runtime.getRuntime().exec(cmd);