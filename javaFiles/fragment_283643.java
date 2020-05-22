if (!selectionModel.isSelectionEmpty()) {
    EventList<Member> selectedMembers = selectionModel.getSelected();
    for (int i = 0; i<selectedMembers.size(); i++) {
        Member member = selectedMembers.get(i);
        //update accordingly...
        //member.setXXX(...); 
        selectedMembers.set(i, member);
     }
}