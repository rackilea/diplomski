try {
    TabContext.getCurrentInstance().setTabsRendered(true);
    TabContext.getCurrentInstance().addOrSelectTab("Your Tab Name",
                                                       "/WEB-INF/task-flow-definition.xml#task-flow-definition");
} catch (TabContext.TabOverflowException e) {
    e.printStackTrace();
}