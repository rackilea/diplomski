/**
 * The type Sp get payment.
 * A StoredProcedure class where we define IN and OUT parameters.
 */
@Component
public class SPGetSinglePayment extends StoredProcedure {
  public static final String PROCEDURE_GET_PAYMENT = "GET_PAYMENT";
  public static final String PROCEDURE_GET_PAYMENT_PARAM_IN_ID = "P_PAYMENT_ID";
  public static final String PROCEDURE_GET_PAYMENT_PARAM_OUT_RESULT = "PAYMENT_RESULT";

  public SPGetSinglePayment(final DataSource dataSource) {
    super(dataSource, PACKAGE_NAME + PROCEDURE_GET_PAYMENT);
    declareParameter(new SqlParameter(PROCEDURE_GET_PAYMENT_PARAM_IN_ID, OracleTypes.VARCHAR));
    declareParameter(new SqlOutParameter(PROCEDURE_GET_PAYMENT_PARAM_OUT_RESULT, OracleTypes.CURSOR));
    compile();
  }
}