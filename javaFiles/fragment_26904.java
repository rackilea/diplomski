Resource resource = acquire(resource);
try {
    use(resource);
} finally {
    resource.release();
}