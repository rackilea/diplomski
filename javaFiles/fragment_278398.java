@Override
protected void openExcelFile(final Resource resource) throws Exception {
    workbookStream = resource.getInputStream();
    if (!workbookStream.markSupported() && !(workbookStream instanceof PushbackInputStream)) {
        throw new IllegalStateException("InputStream MUST either support mark/reset, or be wrapped as a PushbackInputStream");
    }

    [...]
}