public interface GroupIdentifier {
    Integer getRevision();

    default GroupIdentifier getNextRevisionIdentifier(GroupIdentifier identifier) {
        return new GroupIdentifier() {
            @Override
            public Integer getRevision() {
                return identifier.getRevision() + 1;
            }
        };
    }
}