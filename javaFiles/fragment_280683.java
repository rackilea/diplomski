public static String loadQueryFromFile(@NonNull String fileName) {
    try {
        Resource resource = new ClassPathResource("sql/" + fileName);
        return StreamUtils.copyToString(resource.getInputStream(), Charset.defaultCharset());
    } catch (Exception e) {
        log.error("Error occurred during loading sql file to string, file=" + fileName, e);
        throw new QueryNotLoadedException();
    }
}