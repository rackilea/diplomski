public class ColorColumnLabelProvider extends ColumnLabelProvider implements IColorProvider {

    @Override
    public Color getBackground(Object element) {
        return null;
    }

    @Override
    public Color getForeground(Object element) {
        return YOUR_COLOR;
    }

    @Override
    public String getText(Object element) {
        AplotResultsDataModel.ResultsData p = (AplotResultsDataModel.ResultsData) element;
        return p.getPrinterProfile();
    }

}