public class NoTransparencyCustomizer implements JRChartCustomizer{
    @Override
    public void customize(JFreeChart chart, JRChart jrchart) {
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelShadowPaint(Color.GRAY);       
    }
}