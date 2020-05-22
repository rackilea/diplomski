String[] gpgCommands = new String[] {
        "gpg",
        "--passphrase",
        "password",
        "--decrypt",
        "test-files/accounts.txt.gpg"
};

Process gpgProcess = Runtime.getRuntime().exec(gpgCommands);
BufferedReader gpgOutput = new BufferedReader(new InputStreamReader(gpgProcess.getInputStream()));
BufferedReader gpgError = new BufferedReader(new InputStreamReader(gpgProcess.getErrorStream()));