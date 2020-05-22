chkRel5.selectedProperty().addListener(new ChangeListener<Boolean>() {

@Override
public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
filteredObjects.setPredicate(obj -> {
    if (!chkRel5.isSelected() && obj.getVersion() == 5) {
        return false;
    }

    if (!chkRel6.isSelected() && obj.getVersion() == 6) {
        return false;
    }

    if (chkLiveObj.isSelected() && !obj.getLive()) {
        return false;
    }

    if (txtFilter.getText().trim().length() > 0) {
        String lowerCaseFilter = txtFilter.getText().trim().toLowerCase();
        if ( obj.getName().toLowerCase().contains(lowerCaseFilter) ||
             obj.getLocation().toLowerCase().contains(lowerCaseFilter)) {
        } else {
            return false;
        }
    }
    return true;
  });
    sortedObjects = new SortedList<>(filteredObjects);
  }
});