void printStructure(IContainer container, String intent) {
    for(IResource member : folder.members()) {
        System.out.println(intent + member.getName());
        if (member instanceof IContainer) {
            printStructure((IContainer)member, intent + "  ");
        }
    }
}