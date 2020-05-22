//Store and retrieve data used by Views within the application
//This allows us to securely pass parameters between Views.
private ViewData viewData = null;

public ViewData setViewData(String accountId, String accountLevel,
        String ymId, String awId, String adAwardGroup, String adScoutGroup, 
        String caId, Integer numberOfGroupsStarted, String groupSection) {
    getThreadLocalRequest().getSession(true).setAttribute
    (accountId, new ViewData());
    viewData.setaccountId(accountId);
    viewData.setaccountLevel(accountLevel);
    viewData.setymId(ymId);
    viewData.setawId(awId);
    viewData.setadAwardGroup(adAwardGroup);
    viewData.setadScoutGroup(adScoutGroup);
    viewData.setcaId(caId);
    viewData.setnoGroupsStarted(numberOfGroupsStarted);
    viewData.setsection(groupSection);
    return viewData;
}