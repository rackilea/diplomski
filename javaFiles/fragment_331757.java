override getScope(EObject context, EReference reference) {
    if (reference === MyDslPackage.Literals.QNAME__PATH) {
        if (context instanceof QName) {
            val result = newArrayList
            for (field : context.data.type.fields) {
                result.add(EObjectDescription.create(QualifiedName.create(field.name), field))
            }
            System.err.println(result)
            return new SimpleScope(IScope.NULLSCOPE, result)

        }
    }
    super.getScope(context, reference)
}