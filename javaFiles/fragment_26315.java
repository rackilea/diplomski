public class DeleteUsersWorker extends SwingWorker<List<User>, User> {

    private UserTableModel model;
    private List<User> users;

    public DeleteUsersWorker(UserTableModel model, List<User> users) {
        this.model = model;
        this.users = users;
    }

    protected List<User> doInBackground() {
        UserDao dao = new UserDao();
        for (User user : users) {
            dao.delete(user);
            publish(user);
        }
        return users;
    }

    protected void process(List<User> users) {
        for (User user : users) {
            model.remove(user);
        }
    }
}