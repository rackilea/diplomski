public Map<String,Set<Person>> getPatientsPerSpecialization(){
    return this.docLib
               .values()
               .stream()
               .collect(Colectors.groupingBy(Doctor::getSpecialization,
                                             Collectors.mapping(Doctor::getPatients,toSet()))
                       );
}