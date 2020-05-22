public class CustomKeywords {

    @Keyword
    def runBatch(String path) {
        def cmd = "cmd /c \"java -jar \"" + path + "\"\"";
        runCmd(cmd)
    }

    def runCmd(String cmd) {
        KeywordUtil.logInfo("cmd: ${cmd}")

        def proc = cmd.execute();
        def outputStream = new StringBuffer();
        def errStream = new StringBuffer()
        proc.waitForProcessOutput(outputStream, errStream);
        println(outputStream.toString());
        println(errStream.toString())

        if(proc.exitValue() != 0){
            KeywordUtil.markFailed("Out:" + outputStream.toString() + ", Err: " + errStream.toString())
        }
    }

}