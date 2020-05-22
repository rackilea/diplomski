ActionEvent event;
long when;

when  = System.currentTimeMillis();
event = new ActionEvent(button, ActionEvent.ACTION_PERFORMED, "Anything", when, 0);

for (ActionListener listener : button.getActionListeners()) {
    listener.actionPerformed(event);
}