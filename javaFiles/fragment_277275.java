private Application application;

private Map<JButton, Runnable> buttons = new LinkedHashMap<>();
public void addButton(JButton button, Runnable handler){
    buttons.put(button, handler);
}
class ActionHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        // either iterate:
        for(Map.Entry<JButton, Runnable> entry : buttons.entrySet()){
            if(e.getSource()==entry.getKey()){
                entry.getValue().run();
                break;
            }
        }

        // or (more efficient) access directly:
        Runnable handler = buttons.get(e.getTarget());
        if(handler!=null)handler.run();
    }
}