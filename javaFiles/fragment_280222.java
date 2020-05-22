public SearchItemType getElementByOpenedRowID(SearchItemType gridResult, String selectedRowId) {
    // stop at null
    if (gridResult == null) {
        return null;
    }
    if (gridResult.getId().equals(selectedRowId)) {
        return gridResult; // return once found
    }

    // check all of the children
    for (SearchItemType child : gridResult.getChildItem()) {
        // do the search again for every child
        SearchItemType result = getElementByOpenedRowID(child, selectedRowId);
        if (result != null) {
            // return once found and sent it all the way to the top
            return result;
        }
    }
    return null;
}