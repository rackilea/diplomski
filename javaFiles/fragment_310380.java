public class GroupAttachments {

    public Path getPath() {
        return Paths.get(msg + getGroupId() + "/" + getFileIdentifier());
    }
}