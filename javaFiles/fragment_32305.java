private void addContextMenu(SampleContributionFactory fac) {
     final IMenuService menuService = (IMenuService) PlatformUI.getWorkbench().getService (IMenuService.class);
     menuService.addContributionFactory(fac);
}

class SampleContributionFactory extends AbstractContributionFactory{

    SampleContributionFactory(final String menuID) {
        super("menu:" + menuID, null);
    }

    @Override
    public void createContributionItems(IServiceLocator serviceLocator,
            IContributionRoot additions) {      
        // add Command Contribution item
        additions.addContributionItem(<YOUR CONTRIBUTION ITEM>, null);
    // add one more Command Contribution item
    ....
    } 
}