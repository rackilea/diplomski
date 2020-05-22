// PSUEDO CODE
public class FLPatternCustomComponent extends SearchComponent {

    @Override
        //Gauranteed to be called before any other SearchComponent.process
    public void prepare(ResponseBuilder rb) throws IOException {
           SolrParams params = rb.req.getParams();
           //Input fl=field_*
           String[] inputFl = params.getParams(CommonParams.FL);
           Collection<String> existingFl = rb.req.getSearcher().getFieldNames();
           //process & find matching fields{
           SolrQuery newFields = new SolrQuery();
           newFields.set(CommonParams.FL, "field_1,field_2,field_3,field_4");
           AppendedSolrParams appendedParams = new AppendedSolrParams(params, q);
           rb.req.setParams(appendedParams);

           super.prepare(rb);
        }

    @Override
    public void process(ResponseBuilder rb) throws IOException {
        //Process request
        super.process(rb);
    }       
}