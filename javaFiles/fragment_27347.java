public Map<String,Set<Person>> getPatientsPerSpecialization(){
    return this.docLib
               .values()
               .stream()
               .collect(Colectors.groupingBy(Doctor::getSpecialization,
                                             Collectors.mapping(Doctor::getPatients,toSet()))
                       )
               .entrySet()
               .stream()
               .collect (Collectors.toMap (e -> e.getKey(),
                                           e -> e.getValue().stream().flatMap(c -> c.stream()).collect(Collectors.toSet()))
                        );
}