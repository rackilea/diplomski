List<B> Bs = DAO.getAllRelevantAsAsList()
    .stream()
    .map(a -> new B() { 
        public String getName() { a.getName(); } 
        public void setName(String name) { a.setName(name); }
        /** other delegated getters and setters **/
    }).collect(Collectors.toList());