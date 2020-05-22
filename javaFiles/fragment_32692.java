ext {
    isLocal = System.getenv('ENV') == 'LOCAL'
}

jar {
    if (isLocal) version = 'LOCAL'
}