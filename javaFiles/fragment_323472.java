@PersistenceContext( unitName = "youPersistenceUnitHere" )
private EntityManager _entityManager;

public List<ProductDescriptors> getProductDescriptorsBySku( String sku ) {
   Query query = _entityManager.createQuery( "Select ProductDescriptors from ProductDescriptors pd where pd.products.sku = ?1" );
   query.setParameter( 1, sku );
   return new ArrayList<ProductDescriptors>( query.getResultList() );
}