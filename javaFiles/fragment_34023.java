class DeltaJResourceDescriptionStrategy extends XbaseResourceDescriptionStrategy {

    public static val TYPE = 'ModifiesUnit'

    override def createEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
        var custom = true
        try {
            if (eObject instanceof ModifiesUnit) {
                if (!eObject.eIsProxy) {
                    val qname = qnp.getFullyQualifiedName(eObject.unit)
                    acceptor.accept(EObjectDescription.create(qname, eObject, eObject.createModifiesUnitUserData))
                }
            }
        } catch (Exception e) {
            custom = false
        }
        super.createEObjectDescriptions(eObject, acceptor) && custom
    }

    def createModifiesUnitUserData(ModifiesUnit mu) {
        val map = newHashMap
        map.put(TYPE, qualifiedNameProvider.getFullyQualifiedName(mu.unit).toString)
        map
    }
}