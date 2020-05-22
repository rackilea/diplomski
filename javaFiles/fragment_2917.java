private void buildSplashView() {
    wrapperLayout.addComponent(text1);//wrapperLayout is a vertical Layout
    wrapperLayout.addComponent(welcome);
    wrapperLayout.addComponent(panel);
    wrapperLayout.setComponentAlignment(welcome, Alignment.MIDDLE_CENTER);
    wrapperLayout.setComponentAlignment(text1, Alignment.MIDDLE_CENTER);
    wrapperLayout.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);

    addComponent(wrapperLayout);
    setComponentAlignment(wrapperLayout, Alignment.MIDDLE_CENTER);
    setSizeFull();

    panel.setSizeUndefined();
    panel.setContent(formLayout);

    welcome.setSizeUndefined();
    text1.setSizeUndefined();

    formLayout.addComponent(toLoginPage);
    formLayout.setComponentAlignment(toLoginPage, Alignment.MIDDLE_CENTER);
    formLayout.setSizeFull();
}