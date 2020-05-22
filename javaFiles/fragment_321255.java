public class BarStackedComposer extends SelectorComposer<Window> 
{
@Wire
Charts chart;

BarStackedData barStackedData;

public void doAfterCompose(Window comp) throws Exception {
    super.doAfterCompose(comp);

    // get spring bean 
    barStackedData = (BarStackedData) Registry.getApplicationContext().getBean("barStackedData");

    chart.setModel(BarStackedData.getCategoryModel());

    chart.getYAxis().setMin(0);
    chart.getYAxis().setTitle("Total fruit consumption");

    chart.getLegend().setBackgroundColor("#FFFFFF");
    chart.getLegend().setReversed(true);

    chart.getPlotOptions().getSeries().setStacking("normal");

    chart.getCredits().setEnabled(false);
 }
}