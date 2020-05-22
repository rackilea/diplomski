package example;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.StrMinMax;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.exception.SuperCsvCellProcessorException;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

public class TestSuppressExceptions {

    private static final CellProcessor[] PROCESSORS = {
            new SuppressException(new StrMinMax(0, 4)),
            new SuppressException(new NotNull()) };

    private static final String[] HEADER = { "name", "age" };

    public static void main(String[] args) throws Exception {

        final StringWriter stringWriter = new StringWriter();
        ICsvBeanWriter beanWriter = null;
        try {
            beanWriter = new CsvBeanWriter(stringWriter,
                    CsvPreference.STANDARD_PREFERENCE);

            beanWriter.writeHeader(HEADER);

            // set up the data
            Person valid = new Person("Rick", 43);
            Person nullAge = new Person("Lori", null);
            Person totallyInvalid = new Person("Shane", null);
            Person valid2 = new Person("Carl", 12);
            List<Person> people = Arrays.asList(valid, nullAge, totallyInvalid,
                    valid2);

            for (Person person : people) {
                beanWriter.write(person, HEADER, PROCESSORS);

                if (!SuppressException.SUPPRESSED_EXCEPTIONS.isEmpty()) {
                    System.out.println("Suppressed exceptions for row "
                                        + beanWriter.getRowNumber() + ":");
                    for (SuperCsvCellProcessorException e :
                                        SuppressException.SUPPRESSED_EXCEPTIONS) {
                        System.out.println(e);
                    }
                    // clear ready for next row
                    SuppressException.SUPPRESSED_EXCEPTIONS.clear();
                }

            }

        } finally {
            beanWriter.close();
        }

        // CSV will have empty columns for invalid data
        System.out.println(stringWriter);

    }

}