private void buildSplashView() {
    addComponent(text1);
    addComponent(welcome);
    addComponent(panel);
    setComponentAlignment(welcome, Alignment.MIDDLE_CENTER);
    setComponentAlignment(text1, Alignment.BOTTOM_CENTER);
    setComponentAlignment(panel, Alignment.TOP_CENTER);
    setSizeFull();
    setExpandRatio(text1,0.5f);
    setExpandRatio(panel,0.5f);

    panel.setSizeUndefined();
    panel.setContent(formLayout);

    welcome.setSizeUndefined();
    text1.setSizeUndefined();

    formLayout.addComponent(toLoginPage);
    formLayout.setComponentAlignment(toLoginPage, Alignment.TOP_CENTER);
    formLayout.setSizeFull();
}