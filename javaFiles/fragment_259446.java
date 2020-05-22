final Resource resource = acquire();
try {
    use(resource);
} finally {
    resource.dispose();
}