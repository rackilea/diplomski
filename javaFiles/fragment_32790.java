Table table = new Table();

    List<String> listOfString = (List<String>) table.getList();

    List<UserBean> listOfUserBean = new ArrayList<UserBean>();

    for (int i = 1; i < listOfString.size(); i += 6) {

        UserBean userBean = new UserBean(listOfString.get(i),
                listOfString.get(i + 2), Boolean.parseBoolean(listOfString
                        .get(i + 4)));

        listOfUserBean.add(userBean);
    }

    add(new ListView<UserBean>("listview2", listOfUserBean) {
        protected void populateItem(ListItem<UserBean> item) {
            UserBean userBean = item.getModelObject();
            item.add(new Label("name", userBean.getName()));
            item.add(new Label("id", userBean.getId()));
            item.add(new Label("hasPhoto", String.valueOf(userBean
                    .isHasPhoto())));
        }
    });