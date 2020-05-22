try {
    ProducerTemplate template = ...;
    template.sendBody("direct:start", file);
} finally {
    file.delete();
}