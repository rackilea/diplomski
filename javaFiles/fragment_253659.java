TypeService service = ...;
Type t = service.getTypeById(2);

System.out.println(t.getName());
for(MetaType mt : t.getMetaTypes()){
    System.out.println("\t" + mt.getType().getName() + "-> " + mt.getParentType().getName());
}