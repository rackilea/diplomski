txtFilter.textProperty().addListener((observable, oldValue, newValue) -> {
filteredObjects.setPredicate(obj -> {
    if (!chkRel5.isSelected() && !chkRel6.isSelected()) {
        return false;
    }

    if (newValue == null || newValue.isEmpty()) {
    } else {
        String lowerCaseFilter = newValue.toLowerCase();
        if ( obj.getName().toLowerCase().contains(lowerCaseFilter) ||
             obj.getLocation().toLowerCase().contains(lowerCaseFilter)) {
        } else {
            return false;
        }
    }

    if (chkLiveObj.isSelected() && !obj.getLive()) {
        return false;
    }

    if (!chkRel5.isSelected() && obj.getVersion() == 5) {
        return false;
    }

    if (!chkRel6.isSelected() && obj.getVersion() == 6) {
        return false;
    }

    return true;
  });
});