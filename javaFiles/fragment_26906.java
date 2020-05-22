try (
    Resource resource = acquire(resource);
    SubResource sub = resource.acquire()
) {
    use(resource, sub);
}