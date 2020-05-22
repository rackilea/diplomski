private void executeScript(final String pathToGitBash, final File scriptFileToExecute, final String... arguments) throws IOException, InterruptedException {
        final int offset = 4;
        final String[] command = new String[arguments.length + offset];
        command[0] = pathToGitBash;
        command[1] = "--login";
        command[2] = "-i";
        command[3] = scriptFileToExecute.getAbsolutePath();
        for (int i = 0; i < arguments.length; i++) {
            command[i + offset] = arguments[i];
        }
        final ProcessBuilder builder = new ProcessBuilder(command);
        builder.redirectErrorStream(true);
        final Process process = builder.start();
        IOUtils.copy(process.getInputStream(), System.out);
        IOUtils.copy(process.getErrorStream(), System.err);
        switch (process.waitFor()) {
            case 1:
                LOGGER.error("Parameters for scripts are not correct.");
            break;
            case 0:
                LOGGER.info("Script seemed to execute properly");
            break;
            default:
                LOGGER.info("Unknown returnCode. Script finished with: {}", process.exitValue());
        }
    }