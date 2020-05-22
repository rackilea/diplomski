Action myAction = new Action("", imageDesc) {
    @Override
    public void run() {
        // Perform action
    }
};

IToolBarManager toolBarManager = actionBars.getToolBarManager();
toolBarManager.add(myAction);