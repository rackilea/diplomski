public class DateToCalendar extends CellProcessorAdaptor implements DateCellProcessor {

    public DateToCalendar() {
    }

    public DateToCalendar(final CellProcessor next) {
        super(next);
    }

    public Object execute(final Object value, final CsvContext context) {
        validateInputNotNull(value, context);

        if( !(value instanceof Date) ) {
            throw new SuperCsvCellProcessorException(Date.class, value, context, this);
        }

        Calendar result = Calendar.getInstance();
        result.setTime((Date) value);

        return next.execute(result, context);
    }
}