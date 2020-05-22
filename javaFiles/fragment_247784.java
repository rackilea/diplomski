public void onEditRow(RowEditEvent event) {
    User nutzer = (User) event.getObject();                 

    User user = userFacade.find(nutzer.getId());

    user.setName(nutzer.getName());
    user.setLogin(nutzer.getLogin());

    userFacade.edit(user);
}