Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("cmd /c start cmd.exe /V /k \"ping localhost &&" +
                                                   "set /p userInput=Do you want to exit? [y/n] &&" +
                                                   "echo !userInput!\"");
        } catch (IOException ex) {
        }