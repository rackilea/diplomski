public void populateContext(IXDocReport report, IContext context)
        throws Exception {
context.put("project", getProject());
context.put("developers", getDevelopers());

try (FileOutputStream fOut = new FileOutputStream(servletContext.getRealPath("/") + "filename")) {
    report.process(context, fOut);
} catch (Exception e) {
     // Handle exception
}