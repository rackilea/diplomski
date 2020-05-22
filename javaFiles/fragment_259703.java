// Put in Service Class

public void modifySearchable(Class<?> clazz) {
    for(Field f : clazz.getDeclaredFields()){
        CrudSearchable[] searchableArray = f.getDeclaredAnnotationsByType(CrudSearchable.class);

        for(CrudSearchable searchable : searchableArray){
            if(searchable == null){
                continue;
            }

            Reflector.alterAnnotation(searchable, "attribute", f.getName());
            Reflector.alterAnnotation(searchable, "parentClass", clazz);

            if(!(searchable.mappedAttribute().equals(""))){
                String mappedGetter = "get" + 
                        searchable.mappedAttribute().substring(0, 1).toUpperCase() + 
                        searchable.mappedAttribute().substring(1);

                Reflector.alterAnnotation(searchable, "mappedClass", f.getType());
                Reflector.alterAnnotation(searchable, "mappedGetter", mappedGetter);
            }
        }
    }
}

// Changed Bean

@Id
@GeneratedValue
@Column(name = "MOCK_USER_ID")
private Long id;

@Column(name = "MOCK_USER_NAME")
@CrudSearchable
private String name;

@ManyToOne
@JoinColumn(name = "MOCK_GROUP", nullable = false)
@CrudSearchable(mappedAttribute = "name")
private MockGroup group;

public MockUser(){
    super();
    new Searchable<>().modifySearchable(this.getClass());
}