LoadableDetachableModel<List<GroupSelectionModel>> LDM = new LoadableDetachableModel<List<GroupSelectionModel>>() {

     private static final long serialVersionUID = 1L;

     @Override
     protected String load() {                          
           return ServiceLocator.getInstance().find(GroupService.class).getAllGroups();;
     }
};


AjaxSubmitLink addBtn = new AjaxSubmitLink("addBtn") {

        @Override
        protected void onSubmit(AjaxRequestTarget target, Form<?> f) {

            List<Group> currentGroups = ServiceLocator.getInstance().find(GroupService.class).getAllGroups();
            Group group = new Group();
            group.setGroupType(Group.GroupType.EMAIL);
            group.setMerchant(merchant);
            group.setGroupName(form.getModelObject().getGroupName());


            ServiceLocator.getInstance().find(GroupService.class).saveGroup(group);
            GroupSelectionModel newGroup = new GroupSelectionModel();
            newGroup.setGroup(group);
            newGroup.setGroupSelected(true);
            LDM.getObject().add(newGroup);
    target.addComponent(panel);
        }
    };