public class UrlComparator
  extends OperationResourceInfoComparator
  implements ResourceComparator
{
  public UrlComparator()
  {
    super( null, null );
  }

  @Override
  public int compare( ClassResourceInfo classResourceInfo,
    ClassResourceInfo classResourceInfo2, Message message )
  {
    return 0;
  }

  @Override
  public int compare( OperationResourceInfo operationResourceInfo,
    OperationResourceInfo operationResourceInfo2, Message message )
  {
      // Check if CXF can make a decision
      int cxfResult = super.compare(operationResourceInfo, operationResourceInfo2);
      if (cxfResult != 0)
          return cxfResult;

      int op1Counter = getMatchingRate(operationResourceInfo, message);
      int op2Counter = getMatchingRate(operationResourceInfo2, message);

      return op1Counter == op2Counter
              ? 0
              : op1Counter<  op2Counter
              ? 1
              : -1;
  }

    /**
     * This method calculates a number indicating a good or bad match between
     * values provided within the request and expected method parameters. A
     * higher number means a better match.
     *
     * @param operation
     *            The operation to be rated, based on contained parameterInfo
     *            values.
     * @param message
     *            A message containing query from user request
     * @return A positive or negative number, indicating a good match between
     *         query and method
     */
    protected int getMatchingRate(OperationResourceInfo operation, Message message) {

        List<Parameter> params = operation.getParameters();
        if (params == null || params.size() == 0)
            return 0;

        // Get Request QueryParams
        Set<String> qParams = getParams((String) message.get(Message.QUERY_STRING));

        int rate = 0;
        for (Parameter p : params) {
            switch (p.getType()) {
                case QUERY:
                    if (qParams.contains(p.getName()))
                        rate += 2;
                    else if (p.getDefaultValue() == null)
                        rate -= 1;
                    break;
                // optionally support other parameter types such as headers, etc
                // case HEADER:
                //  break;
                default:
                    break;
            }
        }
        return rate;
    }

    /**
     * @param query
     *            URL Query Example: 'key=value&key2=value2'
     * @return A Set of all keys, contained within query.
     */
    protected Set<String>  getParams(String query) {
        Set<String>  params = new HashSet<String>();
        if (query == null || query.length() == 0)
            return params;

        MultivaluedMap<String, String> allQueries =
                JAXRSUtils.getStructuredParams(query, "&", false, false);
        return allQueries.keySet();
    }
}