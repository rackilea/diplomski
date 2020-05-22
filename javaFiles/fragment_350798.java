// Team selection for notification =================================
        final DropDownChoice teamNotificationChoice = new DropDownChoice("teamNotification", teamList, new IChoiceRenderer() {
            public Object getDisplayValue(Object o) {
                return ((Team) o).getName();
            }
            public String getIdValue(Object o, int i) {
                return Long.toString(((Team) o).getId());
            }
        });
        notifySelectionList.add(teamNotificationChoice);

        // teamUser selection list for notification ========================
        List<ItemUser> choices = UserUtils.convertToItemUserListFromUsers(getJtrac().findUsersForSpace(space.getId()));
        teamUsers = new JtracCheckBoxMultipleChoice("teamUsers", choices, new IChoiceRenderer() {
            public Object getDisplayValue(Object o) {
                return ((ItemUser) o).getUser().getName();
            }
            public String getIdValue(Object o, int i) {
                return ((ItemUser) o).getUser().getLoginName();
            }
        });
        notifySelectionList.add(teamUsers);

        // Add selected teamUsers button ===================================
        Button button = new Button("addUsersToList") {
            @Override
            public void onSubmit(){
                List choices = teamUsers.getChoices();
                String value = teamUsers.getValue();
                for (int index = 0; index < choices.size(); index++) {
                    final ItemUser choice = (ItemUser) choices.get(index);
                    if(isSelected(choice, index, value)&!userSelection.contains(choice)) {
                        userSelection.add(choice);
                    }
                }
                SortUtils.sortItemUsers(userSelection);
                itemUsers.setChoices(userSelection);
                notifyList.add(itemUsers);
                teamUsers.updateModel();
            }
        };
        button.setDefaultFormProcessing(false);
        notifySelectionList.add(button);
        notifySelectionList.setOutputMarkupId(true);

        // notify list ===================================================
        itemUsers = new JtracCheckBoxMultipleChoice("itemUsers", userSelection, new IChoiceRenderer() {
            public Object getDisplayValue(Object o) {
                return ((ItemUser) o).getUser().getName();
            }
            public String getIdValue(Object o, int i) {
                return ((ItemUser) o).getUser().getLoginName();
            }
        });
        itemUsers.setMaxRows(10);
        itemUsers.setOutputMarkupId(true);
        notifyList.setOutputMarkupId(true);
        notifyList.add(itemUsers);

        // Remove selected teamUsers button ===================================
        Button removeButton = new Button("removeUsersFromList") {
            @Override
            public void onSubmit(){
                List choices = itemUsers.getChoices();
                String value = itemUsers.getValue();
                if(value!=""){
                    String[] valueList = itemUsers.getValue().split(";");
                    List<User> userList = new ArrayList<User>();
                    for (String s:valueList){
                        userList.add(getJtrac().loadUser(s));
                    }
                    List<ItemUser> itemUserList = UserUtils.convertToItemUserListFromUsers(userList);
                    for (ItemUser iu:itemUserList) {
                        userSelection.remove(iu);
                    }
                    itemUsers.setChoices(userSelection);
                    notifyList.add(itemUsers);
                }
            }
        };
        removeButton.setDefaultFormProcessing(false);
        notifyList.add(removeButton);