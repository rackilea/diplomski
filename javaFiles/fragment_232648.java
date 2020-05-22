public void testSearch_SortControl_ConvenienceMethod() {
    SortControlDirContextProcessor requestControl;

    // Prepare for first search
    requestControl = new SortControlDirContextProcessor("cn");
    tested.search(BASE, FILTER_STRING, searchControls, callbackHandler,
            requestControl);
    int resultCode = requestControl.getResultCode();
    boolean sorted = requestControl.isSorted();
    assertThat("Search result should have been sorted: " + resultCode, sorted).isTrue();
    List list = callbackHandler.getList();
    assertSortedList(list);
}