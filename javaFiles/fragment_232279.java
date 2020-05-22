public ViewData setViewData(String accountId, String accountLevel,
        String ymId, String awId, String adAwardGroup, String adScoutGroup, 
        String caId, Integer numberOfGroupsStarted, String groupSection) {
    //create a view data object with the specific details
    ViewData viewData = new ViewData();

    viewData.setaccountId(accountId);
    viewData.setaccountLevel(accountLevel);
    viewData.setymId(ymId);
    viewData.setawId(awId);
    viewData.setadAwardGroup(adAwardGroup);
    viewData.setadScoutGroup(adScoutGroup);
    viewData.setcaId(caId);
    viewData.setnoGroupsStarted(numberOfGroupsStarted);
    viewData.setsection(groupSection);

    //store the data in the session so we remember it when the user comes back
    getThreadLocalRequest().getSession(true).setAttribute(accountId, viewData);

    //return the viewdata to the user
    return viewData;
}