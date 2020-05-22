//no annotation here
public interface CreditsRepository extends CrudRepository<Credits, UUID> {

    //if you want to pass Bill object
    List<Credits> findAllByPaymentBill(Bill bill);

    //if you want to pass an id (UUID)
    List<Credits> findAllByPaymentBillId(UUID id);
}