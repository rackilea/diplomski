public void fireActionEvent(ActionEvent evt) {
    ActionListener[] listenerList = listeners.getListeners(ActionListener.class);

    for(int i = listenerList.length-1; i >= 0; --i)
        listenerList[i].actionPerformed(evt);
}