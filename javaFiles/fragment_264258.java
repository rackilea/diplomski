HttpServletResponse response = // ...
File toBeCopied = // ...

try (OutputStream out = response.getOutputStream()) {
    Path path = toBeCopied.toPath();
    Files.copy(path, out);
    out.flush();
} catch (IOException e) {
    // handle exception
}