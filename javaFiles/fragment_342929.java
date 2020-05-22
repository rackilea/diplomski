// Start a spring transaction that wraps the operation
@Transactional
public void removeAddressById(Long addressId) {
  // I'm just locating the address from the database based on some provided id.
  final Address address = addressDao.findById( addressId );
  // break the association between the associated User and Address.
  address.getUser().setAddress( null );
  address.setUser( null );
  // Update the user and remove the address
  // If address owns the one-to-one association, then the merge is unnecessary
  getHibernateTemplate().merge( user );
  getHibernateTemplate().delete( address );
}