package example;

import java.util.ArrayList;
import java.util.List;
import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.exception.SuperCsvCellProcessorException;
import org.supercsv.util.CsvContext;

public class SuppressException extends CellProcessorAdaptor {

    public static List<SuperCsvCellProcessorException> SUPPRESSED_EXCEPTIONS = 
            new ArrayList<SuperCsvCellProcessorException>();

    public SuppressException(CellProcessor next) {
        super(next);
    }

    public Object execute(Object value, CsvContext context) {
        try {
            // attempt to execute the next processor
            return next.execute(value, context);

        } catch (SuperCsvCellProcessorException e) {
            // save the exception
            SUPPRESSED_EXCEPTIONS.add(e);

            // and suppress it (null is written as "")
            return null;
        }
    }
}