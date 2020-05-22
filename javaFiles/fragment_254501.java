for(TypeDeclaration type : cu.getTypes()) {
        // first give all this java doc member
        List<BodyDeclaration> members = type.getMembers();
        // check all member content
        for(BodyDeclaration member : members) {
            // if member state equal ClassOrInterfaceDeclaration, and you can identify it which is inner class
            if(member.isClassOrInterfaceDeclaration()) {
                log.info("class name :{}", member.asClassOrInterfaceDeclaration().getName());
                // get inner class method
                for(MethodDeclaration method : member.asClassOrInterfaceDeclaration().getMethods()) {
                    log.info("Method Name :{}", method.getName());
                }
                VerifyInnerClassAndParse(member.asClassOrInterfaceDeclaration());
            }
        }
    }