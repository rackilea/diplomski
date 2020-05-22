class MyDslScopeProvider extends AbstractMyDslScopeProvider {

    override getScope(EObject context, EReference reference) {
        if (reference === MyDslPackage.Literals.ATTRIBUTE_REF__NAME) {
            // we are scoping the AttributeRef.name cross reference
            val script = EcoreUtil2.getContainerOfType(context, Script)
            if (script !== null) {
                val allImportedCosems = script.includes.map[includedScript.assignments.filter(Cosem)].flatten
                // put the imported cosems into scope
                return Scopes.scopeFor(allImportedCosems)
            }
        }
        super.getScope(context, reference)
    }

}