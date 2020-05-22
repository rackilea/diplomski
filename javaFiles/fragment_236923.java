public TypeSpec aNiceMethod(
     ClassModel classe, TypeName father, ArrayList methods, ArrayList fields) {

   TypeSpec.Builder theClassBuilder = TypeSpec.classBuilder(classe.getName())
       .addModifiers(
           javax.lang.model.element.Modifier.valueOf(
               classe.getProte().toString().toUpperCase()),
               Modifier.FINAL)
       .addMethods(methods)
       .addFields(fields);
   if (father != null) {
        theClassBuilder.superclass(father);
   }
   return theClassBuilder.build();
}