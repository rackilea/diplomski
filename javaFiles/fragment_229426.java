/**
 * Contains methods to call Oracle prepared statements. Responsible for handling procedure specific input and output parameters.
 */
@Component
public class StoredProcedureHelper {
  public static final String PACKAGE_NAME = "A_PACKAGE_NAME.";

  private final SPGetSinglePayment getSinglePayment;
  private final SinglePaymentResponseBuilder singlePaymentResponseBuilder;


  @Autowired
  public StoredProcedureHelper(
        final SPGetSinglePayment getSinglePayment,
        final SinglePaymentResponseBuilder  singlePaymentResponseBuilder,
                                                  ...){
    this.getSinglePayment = getSinglePayment;
    this.singlePaymentResponseBuilder = singlePaymentResponseBuilder;
    ...
  }

  /**
   * Calls stored procedure to get all payment details for given payment.
   *
   * @param id the payment id
   * @return payment details
   */
  public List<SinglePaymentDto> findSinglePayment(final String id) {
    LOG.info(LOG_PATTERN, SPGetSinglePayment.class.getSimpleName(),
        PACKAGE_NAME, PROCEDURE_GET_PAYMENT);
    Object spGetPaymentResult = getSinglePayment.execute(id).get(PROCEDURE_GET_PAYMENT_PARAM_OUT_RESULT);
    Object spGetItineraryDataResult = getItineraryData.execute(id).get(PROCEDURE_GET_ITINERARY_DATA_PARAM_OUT_RESULT);
    return singlePaymentResponseBuilder.build(spGetPaymentResult, spGetItineraryDataResult);
  }