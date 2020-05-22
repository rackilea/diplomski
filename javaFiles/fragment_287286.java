// Linux Terminal
        String prefix = "/bin/bash";
        String c = "-c";
        String terminalCommand = "help";
        String mosquittoCommand = "mosquitto --help";

        ProcessBuilder pb1 = new ProcessBuilder(
                new String[] {prefix, c, terminalCommand});
        ProcessBuilder pb2 = new ProcessBuilder(
                new String[] {prefix, c, mosquittoCommand});