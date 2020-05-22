/**
 * The constructor.
 */
public SampleHandler() {
}

/**
 * the command has been executed, so extract extract the needed information
 * from the application context.
 */
public Object execute(ExecutionEvent event) throws ExecutionException {
    IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
    MessageDialog.openInformation(
            window.getShell(),
            "First",
            "Hello, Eclipse world");

    try
    {
        Runtime r = Runtime.getRuntime();

        String pythonScriptPath = "D:\\python-samples\\test.py";
        Process p = r.exec("python " + pythonScriptPath);

        BufferedReader bfr = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = "";
        while((line = bfr.readLine()) != null) {
        // display each output line form python script
        System.out.println(line);
    }
    }
    catch (Exception e)
    {
    String cause = e.getMessage();
    if (cause.equals("python: not found"))
        System.out.println("No python interpreter found.");
    }
    return null;
}