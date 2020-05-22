private ViewData viewData = null;

public ViewData setViewData(String accountId, String accountLevel, String ymId) {

    viewData = new ViewData();

    viewData.setaccountId(accountId);
    viewData.setaccountLevel(accountLevel);
    viewData.setymId(ymId);

    return viewData;
}