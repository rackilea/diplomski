public class UserName {
    private String userName;
    private JButton button = new JButton();

    public UserName() {
        button.addActionListener(e -> userName = "bob");
    }

    public String getUserName() {
        return userName;
    }
}