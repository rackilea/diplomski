public class GroupEditor extends PropertyEditorSupport{

    private final GroupService groupService;

    public GroupEditor(GroupService groupService){
        this.groupService= groupService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
      Group group = groupService.getById(Integer.parseInt(text));
      setValue(group);
    }
}