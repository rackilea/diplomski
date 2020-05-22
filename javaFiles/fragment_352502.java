/*
 * I extracted the FXCollections.observableArrayList(Collection) out of the FilteredList
 * constructor to more easily see what is going on.
 */

/* 
 * You create a **new** ObservableList using FXCollections.observableArrayList(Collection). This basically
 * creates a *snapshot* of the List returnd by getAllParts() as it currently is. At this point the 4th
 * Part is in that returned List. This means the newly created ObservableList will also contian the new
 * Part (since observableArrayList(Collection) copies the data). However, the *old* ObservableList that
 * was already set on the TableView *does not* contain that 4th Part.
 */
ObservableList<Part> parts = FXCollections.observableArrayList(inventory.getAllParts());

// You create a FilteredList that performs no filtering around "parts". Note
// here that a Predicate that always returns true is equivalent to passing null
// as the Predicate.
FilteredList<Part> filteredData = new FilteredList<>(parts, p -> true);

// Get the search criteria
String newValue = txtPartSearch.getText();

filteredData.setPredicate(part -> {
    if (newValue == null || newValue.isEmpty()) {
        return true; // don't filter if there is no search criteria
                     // since the newValue will be null or blank in this
                     // case no Parts are filtered
    }

    // filter based on lower-case names and search critiera
    String lowerCaseFilter = newValue.toLowerCase();
    if (part.getName().toLowerCase().contains(lowerCaseFilter)) {
        return true;
    }
    // else filter by ID
    return Integer.toString(part.getPartID()).equals(lowerCaseFilter);
});

// Wrap the FilteredList in a SortedList and bind the comparatorProperty to
// the comparatorProperty of the TableView (allows sorting by column).
SortedList<Part> sortedData = new SortedList<>(filteredData);
sortedData.comparatorProperty().bind(tblParts.comparatorProperty());

// Set the sortedData to the TableView
tblParts.setItems(sortedData);