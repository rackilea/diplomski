/**
 * The type Payment response builder. Gets an object from Oracle DB and populates POJOs.
 */
@Component
public class SinglePaymentResponseBuilder {

  /**
   * Builds list of payment transaction details from stored procedure result set.
   *
   * @param getPaymentObject       the object containing payment details result set
   * @param getItineraryDataObject the object containing itinerary data result set
   * @return list of payment details for payment
   */
  public List<SinglePaymentDto> build(final Object getPaymentObject, final Object getItineraryDataObject) {
    final List<Map<String, Object>> spMap = getListOfObjectMaps(getPaymentObject);
    final List<SinglePaymentDto> response = new ArrayList<>();
    for (Map<String, Object> dtos : spMap) {
      SinglePaymentDto payment = new SinglePaymentDto(
          new PaymentInfo(getStringValue(dtos.get(PaymentInfo.PAYMENT_ID)),
... build and return response