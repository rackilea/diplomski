private static StringBuilder Get_Fields(TypeDeclaration c) //Get all field names
 {
    List<BodyDeclaration> members = c.getMembers();
    StringBuilder str=new StringBuilder();

    if(members != null) {
        for (BodyDeclaration member : members) {

            //Check just members that are FieldDeclarations
            FieldDeclaration field = (FieldDeclaration) member;

            str.append(field.getVariables().get(0).getId().getName());
            str.append("\n");

        }

    }

     return str;
 }