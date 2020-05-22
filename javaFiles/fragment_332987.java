public void elementChanged(ElementChangedEvent event) {
     IJavaElementDelta delta= event.getDelta();
        if (delta != null) {               
            delta.getCompilationUnitAST().accept(new ASTVisitor() {

             @Override
             public boolean visit(MethodDeclaration node) {
                 String name = ( (TypeDeclaration) node.getParent()).getName()
                     .getFullyQualifiedName() + "." + node.getName().getFullyQualifiedName();

                 boolean changedmethodvalue = false;

                 if (subtrees.containsKey(name)){

                    changedmethodvalue = !node.subtreeMatch(new ASTMatcher(),subtrees.get(Name));

                     if(changedmethodvalue){

                      System.out.println("method  changed"+Name+":"+changedmethodvalue);

                      /**
                       * Store the changed method inside the hash map for future reflection.
                       */

                      changed.put(Name, (IMethod) node.resolveBinding().getJavaElement());

                      /**
                       * setting up the hash map value each time changes happened.
                       * 
                       */
                      ModificationStore.setChanged(changed);



                      }
                 }
                 else{

                     // No earlier entry found, definitely changed
                     methodHasChanged = true;
                     System.out.println("A new method is added");

                 }

             }
                      /**
                     * updating the subtree structure 
                     */
                       subtrees.put(mName, node);

                       return true;
                   }
               });

       }
   }
}