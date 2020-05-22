class DeltaJIndex {

    @Inject extension ResourceDescriptionsProvider
    @Inject extension QualifiedNameProvider
    @Inject extension ResourceSet

    def getAllResourceDescriptions() {
        createResourceDescriptions.allResourceDescriptions
    }

    def getAllModifyUnitsOf(ClassOrInterface ci) {
        val Set<ModifiesUnit> units = newHashSet
        val Set<Resource> resources = newHashSet
        val ciQn = qnProvider.getFullyQualifiedName(ci).toString

        rdProvider.getResourceDescriptions(ci.eResource).allResourceDescriptions.forEach [ list |
            list.exportedObjects.forEach [ object |
                if (object.userDataKeys.contains(TYPE) && object.getUserData(TYPE) == ciQn) {
                    val res = set.getResource(object.EObjectURI, true)
                    if (!resources.contains(res)) {
                        res.unload
                        res.load(null)
                        resources.add(res)
                    }
                    units.add(res.getEObject(object.EObjectURI.fragment) as ModifiesUnit)
                }
            ]
        ]
        units
    }
}