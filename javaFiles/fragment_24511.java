CSharpDllHandler dllHandler = new CSharpDllHandler(
                ${yourFrameworkAdapterDllLocation});

dllHandler.loadAssemblies(
    ${yourOriginalDllPath},${pathToTheUsedLog4netDllFile});             
dllHandler.configureLogging(${log4net.config file path});
dllHandler.runKeyword("JAVA Action", "JAVA Xpath", "JAVA INPUT",
                "JAVA VERIFY");
dllHandler.runKeyword("JAVA Action2", "JAVA Xpath2", "JAVA INPUT2",
                "JAVA VERIFY2");