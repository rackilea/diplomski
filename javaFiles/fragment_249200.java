public class ShowExpressionDynamicReports extends AbstractSimpleExpression<Boolean> {

    private String fieldName;

    public ShowExpressionDynamicReports(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public Boolean evaluate(net.sf.dynamicreports.report.definition.ReportParameters reportParameters) {
        return reportParameters.getValue(fieldName) != null;
      }
    }