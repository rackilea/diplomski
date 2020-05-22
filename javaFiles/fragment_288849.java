String[] requestParmArray = new String[] {
    "java",
    "-classpath",
    "c:\\j\\test.jar",
    "test.connect",
    fileName,
    "new"
};
Process ls_proc = Runtime.getRuntime().exec(requestParmArray);