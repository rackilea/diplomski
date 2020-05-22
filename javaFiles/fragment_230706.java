public class ColorColumnLabelProvider extends ColumnLabelProvider {
    @Override
    public void update(ViewerCell cell)
    {
        Object element = cell.getElement();
        if(element instanceof AplotResultsDataModel.ResultsData)
        {
            AplotResultsDataModel.ResultsData p = (AplotResultsDataModel.ResultsData) element;

            cell.setForeground(YOUR_COLOR);
            switch(cell.getColumnIndex())
            {
                case 0:
                    cell.setText(p.YOUR_FIRST_TEXT);
                    break;
                case 1:
                    cell.setText(p.YOUR_SECOND_TEXT);
                    break;
                case ...
            }
        }
    }
}