private IOException translateToIOException(String file, String other) {
    // created with message rather than errno
    if (msg != null)
        return new IOException(msg);

    // handle specific cases
    if (errno() == UnixConstants.EACCES)
        return new AccessDeniedException(file, other, null);
    if (errno() == UnixConstants.ENOENT)
        return new NoSuchFileException(file, other, null);
    if (errno() == UnixConstants.EEXIST)
        return new FileAlreadyExistsException(file, other, null);

    // fallback to the more general exception
    return new FileSystemException(file, other, errorString());
}