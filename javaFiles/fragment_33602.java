String[] cmd = {
        "/bin/bash",
        "-c",
        "echo password | python script.py '" + packet.toString() + "'"
    };
Runtime.getRuntime().exec(cmd);