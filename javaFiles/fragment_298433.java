public Class TestA {

 @NotEmpty(groups = {Second.class})
 private String first;

 @NotEmpty(groups = {Second.class})
 @Size(min=3,max=80, groups = {Second.class})
 private String second;

 //getters and setters

}