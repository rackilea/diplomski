private int groupNameIndex = 0;

    @Parsed(field = "GROUP_NAME")
    public String nextGroupName() {
        if (hasMoreGroups()) {
            return isMemberOf.get(groupNameIndex++);
        }
        return null;
    }

    public boolean hasMoreGroups() {
        return isMemberOf != null && groupNameIndex < isMemberOf.size();
    }