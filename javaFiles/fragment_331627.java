public void streamImageContent(String name, HttpServletResponse response)
throws IOException {

    File file = fileService.getFile(name);

    try {
        OutputStream out = response.getOutputStream();
        IOUtils.copy(new FileInputStream(file), out);
        out.flush();
        out.close();

    } catch (IOException e) {
    }
}