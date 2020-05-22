Main.java:
...
User user = new User();
user.setmData(userEntity);
//do this before...
DAO.saveEntityDb(user);

List<MainEntityModel> mainEntityModelList = ...
//...you do this
DAO.saveEntityDb(mainEntityModelList.toArray(new MainEntityModel[0]));