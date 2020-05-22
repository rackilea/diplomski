import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class CsvApp {

    private CsvMapper csvMapper = new CsvMapper();

    private void handle() throws Exception {
        File csvFile = new File("./resource/test.csv").getAbsoluteFile();

        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        MappingIterator<Map<String, String>> iterator = csvMapper.readerFor(Map.class).with(schema).readValues(csvFile);

        SequenceWriter writer = null;
        while (iterator.hasNext()) {
            final Map<String, String> row = iterator.next();
            if (writer == null) {
                writer = createWriter(row).writeValues(System.out);
            }

            // do something ...
            for (Map.Entry<String, String> item : row.entrySet()) {
                row.replace(item.getKey(), item.getValue() + "U");
            }

            // write back
            writer.write(row);
        }

        close(writer);
    }

    private ObjectWriter createWriter(Map<String, String> row) {
        CsvSchema.Builder writeSchema = new CsvSchema.Builder();
        writeSchema.setUseHeader(true);
        row.keySet().forEach(writeSchema::addColumn);

        return csvMapper.writerFor(Map.class).with(writeSchema.build());
    }

    private void close(Closeable closeable) throws IOException {
        if (closeable != null) {
            closeable.close();
        }
    }

    public static void main(String[] args) throws Exception {
        new CsvApp().handle();
    }
}