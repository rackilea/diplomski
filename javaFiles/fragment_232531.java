public interface AddView {
    public static final String ADD_ACTION_COMMAND = "Action.add";
    public void setData(int data);
    public void addActionListener(ActionListener listener);
    public void removeActionListener(ActionListener listener);
}