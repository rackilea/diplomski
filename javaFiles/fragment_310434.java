@Post                                       
public void userPost(String name) {
User.getInstance().addUser(name);
}

@Post                                       
public void filePost(File file) {
//processing the file, ONLY IF the userPost method is already invoked
}