String[] cmd = {
"/bin/sh",
"-c",
"./my_script | sed -r 's/\\x1B\\[([0-9]{1,2}(;[0-9]{1,2})?)?[m|K]//g'"
};

Process p = Runtime.getRuntime().exec(cmd);