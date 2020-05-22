public boolean shareFile(File source, User otherUser) throws ShareException {
    if (otherUser.hasBlocked(this) {
        throw new ShareException("You cannot share with that user.");
    }
    try {
        return copyFile(source, otherUser.getSharedFileDestination(source));
    } catch (CopyException e) {
        throw new ShareException("Sharing failed due to an internal error", e);
    }
}