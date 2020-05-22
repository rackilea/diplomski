public class Handler extends AbstractHandler{

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        String filePath = event
                .getParameter("press.command.parameter");

        IWorkbenchPage workbenchPage = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage();

          IViewPart view = workbenchPage.findView("freechart.views.ChartView");

          if (view instanceof ChartView) {
              ChartView myView = (ChartView)view;
              myView.frame.dispose();
              myView.createChart(filePath);
              myView.parent.pack();
              myView.parent.layout(true);
          }
        return null;
    }

}