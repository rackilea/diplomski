/**
 * The type Sp get toothbrush.
 * A StoredProcedure class where we define IN and OUT parameters.
 */
@Component
public class SPGetToothbrush extends StoredProcedure {
  public static final String PROCEDURE_GET_TOOTHBRUSH = "GET_IDENTIFIER";
  public static final String PROCEDURE_GET_TOOTHBRUSH_PARAM_IN_INSTRUMENT_ID = "P_TOKEN";
  public static final String PROCEDURE_GET_TOOTHBRUSH_PARAM_OUT_RESULT = "OUT_IDENTIFIER";

  /**
   * Instantiates a new Sp get toothbrush.
   *
   * @param dataSource is populated by db2 properties by use of @Qualifier.
   */
  public SPGetToothbrush(@Qualifier("db2") final DataSource dataSource) {
    super(dataSource, StoredProcedureToothbrushHelper.PACKAGE_NAME + PROCEDURE_GET_TOOTHBRUSH);
    declareParameter(new SqlParameter(PROCEDURE_GET_TOOTHBRUSH_PARAM_IN_INSTRUMENT_ID, OracleTypes.VARCHAR));
    declareParameter(new SqlOutParameter(PROCEDURE_GET_TOOTHBRUSH_PARAM_OUT_RESULT, OracleTypes.VARCHAR));
    compile();
  }
}