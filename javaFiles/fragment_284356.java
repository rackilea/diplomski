public class ItemSelectionComponent extends Panel{
private static final long serialVersionUID = 6670144847L;
private LoadableDetachableModel<List<GroupSelectionModel>> model;

public ItemSelectionComponent(String id,LoadableDetachableModel<List<GroupSelectionModel>> model){
    super(id);
    this.model = model;
    init();

}

private void init(){
    WebMarkupContainer groupSelectionContainer = new WebMarkupContainer("groupSelectionContainer");
    RepeatingView repeater = new RepeatingView("groupList");
    WebMarkupContainer groupList;

    for(final GroupSelectionModel m : model.getObject()){
        groupList = new WebMarkupContainer(repeater.newChildId());
        WebMarkupContainer groupNameContainer = new WebMarkupContainer("groupNameContainer");
        groupNameContainer.add(new Label("groupName", m.getGroup().getGroupName()));
        groupList.add(groupNameContainer);
        repeater.add(groupList);                  
    }
    groupSelectionContainer.add(repeater);
    this.add(groupSelectionContainer);
}
}