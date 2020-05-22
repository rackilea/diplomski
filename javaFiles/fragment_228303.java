public void setSelectedTab(final int tab) throws InterruptedException, InvocationTargetException{
    if(!SwingUtilities.isEventDispatchThread()){
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                animatedTabbedPane.setSelectedIndex(tab);
            }
        });
    }
    else
        animatedTabbedPane.setSelectedIndex(tab);
}