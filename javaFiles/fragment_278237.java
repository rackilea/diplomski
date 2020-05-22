public void testFreeMarker() throws Exception {

    List<Invoice> invoices = Arrays.asList(
       new Invoice( "note1", "amount1" ), 
       new Invoice( "note2", "amount2" ) );
    Map<String, Object> root = new HashMap<String, Object>();
    root.put( "invoices", invoices );
    StringWriter out = new StringWriter();

    Configuration cfg = new Configuration();
    cfg.setClassForTemplateLoading( FreemarkerUtils.class, "/templates" );
    cfg.setObjectWrapper( new DefaultObjectWrapper() );
    Template temp = cfg.getTemplate( "listTest.ftl" );
    temp.process( root, out );

    System.out.println( out.getBuffer().toString() );
}