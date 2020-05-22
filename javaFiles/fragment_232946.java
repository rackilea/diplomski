Runtime runtime = Runtime.getRuntime()
    Process croppingProcess = runtime.exec(runtimeCommand)
        int processOutput = croppingProcess.waitFor()
        if(processOutput == 0){
            success = true
    //do your work here
}