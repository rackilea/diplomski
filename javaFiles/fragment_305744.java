class MyDslOutlineTreeProvider extends DefaultOutlineTreeProvider {

    // xtext does reflective polymorphic dispatch on params
    def protected _createChildren(IOutlineNode parentNode, SourceFile modelElement) {
            for (s : modelElement.statements) {
                val firstDecl = s.statement?.declare
                if (firstDecl instanceof StructDeclaration) {
                    val secondDecl = firstDecl.declare
                    if (secondDecl !== null) {
                        createNode(parentNode, secondDecl)
                    }
                } else if (firstDecl instanceof ClassDeclaration) {
                    val secondDecl = firstDecl.declare
                    if (secondDecl !== null) {
                        createNode(parentNode, secondDecl)
                    }
                }

            }
    }

}