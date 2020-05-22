pid = fork()
if pid then
    # This is the parent process. Execute your ruby code here
    # then kill the process running the java server
    system "kill #{pid}"
else
    # this is the child process, run the java server here
    system "java -jar myJavaServer.jar -someArgument -otherArgument"
end