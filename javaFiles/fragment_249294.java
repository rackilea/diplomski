ObservableList<InitialDBItemsPOJO> data;
List countriesListListItems;

String countriesListListItemsQuery = "from InitialDBItems";
data = FXCollections.observableArrayList();

countriesListListItems = new ManageItems().listItems(countriesListListItemsQuery);

for (Iterator iterator = countriesListListItems.iterator(); iterator.hasNext();) {
    InitialDBItemsPOJO countriesListListItemsIt = (InitialDBItemsPOJO) iterator.next();

    data.add(countriesListListItemsIt.getCountriesList());
}
return data;