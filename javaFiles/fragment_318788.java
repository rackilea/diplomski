AjaxTabbedPanel<CustomAjaxTab> tabbedPanel = new AjaxTabbedPanel<CustomAjaxTab>("tabbedPanel", tabList, new Model<>(0)) {

private static final long serialVersionUID = 1L;

@Override
protected WebMarkupContainer newLink(final String linkId, final int index) {
    AjaxFallbackLink<Void> link = new AjaxFallbackLink<Void>(linkId) {

        private static final long serialVersionUID = 1L;

        @Override
        protected void updateAjaxAttributes( AjaxRequestAttributes attributes ) {
            super.updateAjaxAttributes( attributes );

            AjaxCallListener ajaxCallListener = new AjaxCallListener();
            //very important to use the "return" if not then nothing happens with the response
            ajaxCallListener.onPrecondition("return " + WARN_ON_CHANGE);

            attributes.getAjaxCallListeners().add( ajaxCallListener );
        }

        @Override
        public void onClick(final AjaxRequestTarget target) {
            TabbedPanel<CustomAjaxTab> selectedTab = setSelectedTab(index);
            CustomAjaxTab tab = tabList.get(index);
            if (target != null) {

                tab.getPanel(linkId);

                target.add(selectedTab);
            }
            onAjaxUpdate(target);
        }
    };

    link.add(new WarnChangePromptOnClickBehavior());
    return link;
}
};