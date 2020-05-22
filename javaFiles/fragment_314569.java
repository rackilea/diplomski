// Correct, postalCode is the ID field in Address domain
   @Repository
   public interface AddressRepository extends DocumentDbRepository<Address, String> {
      List<Address> findByPostalCode(String postalCode);
   }

   // Query
   List<Address> result = repository.findByPostalCode(postalCode);