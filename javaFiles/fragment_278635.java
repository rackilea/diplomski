if (listOfEntities.getAll()!=null
    && !listOfEntities.getAll().stream()
           .allMatch(entity -> isEntityDateValid(entity.getStartDate())
                     && isEntityDateValid(entity.getEndDate()))) {
    return false;
}