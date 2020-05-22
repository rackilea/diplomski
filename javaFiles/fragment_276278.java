// The command to run in a PTY...
    String[] cmd = { "java", "-jar", "path_to_jar" };
    // The initial environment to pass to the PTY child process...
    String[] env = { "TERM=xterm" };

    PtyProcess pty = PtyProcess.exec(cmd, env);

    OutputStream os = pty.getOutputStream();
    InputStream is = pty.getInputStream();

    // ... work with the streams ...

    // wait until the PTY child process terminates...
    int result = pty.waitFor();

    // free up resources.
    pty.close();