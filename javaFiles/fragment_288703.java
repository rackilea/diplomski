try (InputStreamReader isr = new InputStreamReader(entity.getContent(), "UTF-8"); 
     Reader reader = new BufferedReader()) {
    content = IOUtils.toString(reader);
    EntityUtils.consume(entity);
} catch (IOException e) {
    ...
}