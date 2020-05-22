try {
    Paths.get(path);
} catch (InvalidPathException | NullPointerException ex) {
    return false;
}
return true;