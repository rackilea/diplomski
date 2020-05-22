import groovy.util.GroovyTestCase
import au.com.bytecode.opencsv.CSVReader
import au.com.bytecode.opencsv.CSVParser

@Grapes([
    @Grab(group='net.sf.opencsv', module='opencsv', version='2.3')
])

class OpenCSVTest extends GroovyTestCase {

    void testParseQuote() {
        CSVParser csv = new CSVParser()

        String[] result = csv.parseLine('"aa","I am ""fine"", what about u?", "232"')

        assert result[0] == 'aa'
        assert result[1] == 'I am "fine", what about u?'
        assert result[2] == '232'
    }
}