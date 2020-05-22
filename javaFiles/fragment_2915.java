private void buildSplashView() {
    addComponent(panel);
    setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
    setSizeFull();

    panel.setContent(formLayout);
    panel.setStyleName(ValoTheme.PANEL_BORDERLESS);

    formLayout.addComponent(welcome);
    welcome.setSizeUndefined();
    formLayout.addComponent(toLoginPage);
    formLayout.setComponentAlignment(toLoginPage, Alignment.MIDDLE_CENTER);
    formLayout.setComponentAlignment(welcome, Alignment.MIDDLE_CENTER);
    formLayout.setSizeFull();
}