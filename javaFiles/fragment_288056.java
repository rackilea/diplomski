if (compilerOptions.produceReferenceInfo) {
    this.qualifiedReferences = new SortedCompoundNameVector();
    this.simpleNameReferences = new SortedSimpleNameVector();
    this.rootReferences = new SortedSimpleNameVector();
    this.referencedTypes = new LinkedHashSet<>();
    this.referencedSuperTypesSet = new HashSet<>();
    this.referencedSuperTypes = new ObjectVector();
} else {
    this.qualifiedReferences = null; // used to test if dependencies should be recorded
    this.simpleNameReferences = null;
    this.rootReferences = null;
    this.referencedTypes = null;
    this.referencedSuperTypesSet = null;
    this.referencedSuperTypes = null;
}