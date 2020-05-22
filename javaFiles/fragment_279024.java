List<ActionListener> listeners = new ArrayList<ActionListener()>;
ActionListener listener = new ActionListener() {
    @Override void actionPerformed(ActionEvent e) {
        // do something
    }
};
for(int i=0; i<4; i++){
    listeners.add(listener);
}