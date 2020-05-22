class DeltaJXImportSectionNamespaceScopeProvider extends XImportSectionNamespaceScopeProvider {

    override List<ImportNormalizer> internalGetImportedNamespaceResolvers(EObject context, boolean ignoreCase) {

        // A scope will only be provided for elements which really need a scope. A scope is only necessary for elements
        // which are siblings of a JavaCompilationUnit or a ModifiesUnit.
        if (context.checkElement) { // (1)
            return Collections.emptyList
        }

        // Finding the container which contains the import section
        val container = context.jvmUnit // (2)

        // For a non null container create the import normalizer list depending of returned element. If the container is
        // null, no scope is needed.
        return if (container != null) { // (3)
            switch (container) {
                JavaCompilationUnit: container.provideJcuImportNormalizerList(ignoreCase)
                ModifiesUnit: container.provideMcuImportNormalizerList(ignoreCase)
            }
        } else {
            Collections.emptyList
        }

    }

    // Iterates upwards through the AST until a ModifiesUnit or a JavaCompilationUnit is found. (2)
    def EObject jvmUnit(EObject o) {
        switch (o) {
            ModifiesUnit: o
            JavaCompilationUnit: o
            default: o.eContainer.jvmUnit
        }
    }

    // Creates the list with all imports of a JCU (3a)
    def List<ImportNormalizer> provideJcuImportNormalizerList(JavaCompilationUnit jcu, boolean ignoreCase) {
        val is = jcu.importSection
        return if (is != null) {
            is.getImportedNamespaceResolvers(ignoreCase)
        } else {
            Collections.emptyList
        }
    }

    // Creates the list of all imports of a ModifiesUnit. This implementation is similar to 
    // getImportedNamespaceResolvers(XImportSection, boolean) // (3b)
    def List<ImportNormalizer> provideMcuImportNormalizerList(ModifiesUnit mu, boolean ignoreCase) {
        val List<ImportNormalizer> result = Lists.newArrayList
        result.addAll((mu.unit.jvmUnit as JavaCompilationUnit).provideJcuImportNormalizerList(ignoreCase))
        for (imp : mu.modifiesImports) {
            if (imp instanceof AddsImport) {
                val decl = imp.importDeclaration
                if (!decl.static) {
                    result.add(decl.transform(ignoreCase))
                }
            }
        }
        result
    }

    // Creates an ImportNormalizer for a given XImportSection
    def ImportNormalizer transform(XImportDeclaration decl, boolean ignoreCase) {
        var value = decl.importedNamespace
        if (value == null) {
            value = decl.importedTypeName
        }
        return value.createImportedNamespaceResolver(ignoreCase)
    }

    // Determines whether an element needs to be processed. (1)
    def checkElement(EObject o) {
        return o instanceof DeltaJUnit || o instanceof Delta || o instanceof AddsUnit || o instanceof ModifiesUnit ||
            o instanceof RemovesUnit
    }
}