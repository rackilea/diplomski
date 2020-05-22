public void update(String userID, Filter filter) {
    users.stream()
         .filter(element -> element.getUserId().equals(userID)) // get relevant user[s]
         .flatMap(element -> element.getFilters().stream()) // get all filters of relevant 
                                                            // user[s]
         .filter(f -> f.getName().equals(filter.getName())) // keep only relevant filters
         .forEach (f -> { // run your update on all the relevant filters
              f.setCreatedOn(filter.getCreatedOn());
              f.setDescription(filter.getDescription());
              f.setEnabled(filter.isEnabled());
              f.setFilterValue(filter.getFilterValue());
              f.setReadOnly(filter.isReadOnly());
              f.setModifiedOn(filter.getModifiedOn());
              // f.setName(filter.getName()); can be removed, as commented by markusk
              f.setType(filter.getType());
              f.setValid(filter.isValid());
              f.setEncrypted(filter.isEncrypted());
            });
}