@Override
public void processAdd(AddUpdateCommand cmd) throws IOException {
    SolrInputDocument doc = cmd.getSolrInputDocument();
    String appid = (String)doc.getFieldValue( "appid" );
    String docid = (String)doc.getFieldValue( "docid" );
    doc.addField("uniqueid", appid + "-" + docid);    
    // pass it up the chain
    super.processAdd(cmd);
}