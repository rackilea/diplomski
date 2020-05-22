private void compileGrammar(IResource resource, IProgressMonitor monitor) {
    if (resource != null && resource instanceof IFile && (resource.getName().endsWith(".g4"))) {
        IFile file = (IFile) resource;

        try {
            String outputDirectory = determineBuildFolder(file).toString();
            Log.info(this, "Building  [file=" + file.getFullPath() + "]");
            Log.info(this, "Output to [dir= " + outputDirectory + "]");
            monitor.worked(1);

            Tool tool = new Tool(new String[] { "-o", outputDirectory });
            tool.removeListeners();
            ErrorListener toolErrs = new ErrorListener();
            tool.addListener(toolErrs);
            monitor.worked(1);

            // Prep and process the grammar file
            String loc = file.getLocation().toPortableString();
            Grammar g = tool.loadGrammar(loc);
            tool.process(g, true);
            monitor.worked(1);

            if (toolErrs.hasErrors()) {
                for (ANTLRMessage err : toolErrs.getErrList()) {
                    Log.error(this, err.toString());
                    AntlrDTCore.getDefault().showConsoleMessage(err.toString(), AntlrDTCore.MSG_ERROR);
                }
            }
            if (toolErrs.hasWarnings()) {
                for (ANTLRMessage warn : toolErrs.getWarnList()) {
                    Log.warn(this, warn.toString());
                    AntlrDTCore.getDefault().showConsoleMessage(warn.toString(), AntlrDTCore.MSG_WARNING);
                }
            }

            postCompileCleanup(file, monitor);
            monitor.worked(1);
        } catch (Exception e) {
            Log.error(this, "Build failed.", e);
        }
    }
}