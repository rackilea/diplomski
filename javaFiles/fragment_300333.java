firstNameFilter.addValueChangeListener( e-> this.onFilterChange());
lastNameFilter.addValueChangeListener( e-> this.onFilterChange());
addressFilter.addValueChangeListener( e-> this.onFilterChange());
// sidenote: all filter fields need ValueChangeMode.EAGER to work this way


private void onFilterChange(){
    ldp.setFilter(desc -> {
        boolean fNameMatch = true;
        boolean lNameMatch = true;
        boolean addressMatch = true;

        if(!firstNameFilter.isEmpty()){
            fNameMatch = StringUtils.containsIgnoreCase(desc.getFName(), firstNameFilter.getValue());
        }
        if(!lastNameFilter.isEmpty()){
            lNameMatch = StringUtils.containsIgnoreCase(desc.getLName(), lastNameFilter.getValue());
        }
        if(!addressFilter.isEmpty()){
            addressMatch = StringUtils.containsIgnoreCase(desc.getAddress(), addressFilter.getValue());
        }

        return fNameMatch && lNameMatch && addressMatch;
    });
});