public class StatsServlet extneds HttpServlet{

private static final long serialVersionUID = 1L;

private StatsCreatorProvider statsCreatorProvider;

public void init() {
    statsCreatorProvider = new StatsCreatorProvider();
    statsCreatorProvider.registerStatsCreator( "validate", new ValidateStatsCreator() );
    statsCreatorProvider.registerStatsCreator( "extract" new ExtractStatsCreator() );
    ...
}

protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    StatsContext context = new StatsContext(request,response);
    IStatsCreator creator = statsCreatorProvider.getCreator( context.getOperation() );
    IChart chart = creator.createChart( context );
    String jsonChart = creator.chartToJson(chart);
    creator.sendResponse(jsonChart);
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processRequest(request, response);
}