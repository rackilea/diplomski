@Autowired private ApplicationContext appContext;
@Autowired private DataSource dataSource;

@RequestMapping(value = "/pdf", method = RequestMethod.GET)
public ModelAndView getPdf() {
    JasperReportsPdfView view = new JasperReportsPdfView();
    view.setJdbcDataSource(dataSource);
    view.setUrl("classpath:report.jrxml");
    Map<String, Object> params = new HashMap<>();
    params.put("param1", "param1 value");
    view.setApplicationContext(appContext);
    return new ModelAndView(view, params);
}