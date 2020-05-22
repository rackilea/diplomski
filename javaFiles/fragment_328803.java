public static void goToPage(WebDriver driver, int page) {

    ((JavascriptExecutor) driver)
            .executeScript("mojarra.jsfcljs(document.getElementById('idHere'),"
                           + "{'j_idt##:#:j_idt##':'j_idt##:#:j_idt##','pageIndex':'',"
                           + "'moveToPageNum':'" + page + "'}," + "'');return false");
}