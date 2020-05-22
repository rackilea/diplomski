class Person {    
   @OneToMany(cascade=CascadeType.ALL,
              fetch= FetchType.EAGER)
   private Set<Email> emails = new HashSet();

   // getters/setters and some other attributes are not shown