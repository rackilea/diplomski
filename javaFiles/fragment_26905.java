Resource resource = acquire(resource);
try {
    SubResource sub = resource.acquire();
    try {
        use(sub);
    } finally {
        sub.release();
    }
} finally {
    resource.release();
}