public class MyDatasource extends DataSource{
    public MyDatasource(){
        setDataProtocol(DSProtocol.CLIENTCUSTOM)           
    }

    @Override
    protected Object transformRequest(final DSRequest dsRequest) {

          expensesService.getExpensesByYear(2008,
              new AsyncCallback<ExpenseRecord[]>() {

                @Override
                public void onSuccess(ExpenseRecord[] result) {
                  DSResponse response = new DSResponse();
                  System.out.println("Returned " + result.length + " expense record ");            
                  dsRequest.setAttribute("dsResult", result);
                  Record[] recs = request.getAttributeAsRecordArray("dsResult");
                  response.setData(recs);
                  processResponse(dsRequest.getRequestId(), dsResponse);
                }

                @Override
                public void onFailure(Throwable caught) {
                  DSResponse response = new DSResponse();
                  System.out.println("Failed to run query");
                  processResponse(dsRequest.getRequestId(), dsResponse);
                }

              });

          return dsRequest;
   }