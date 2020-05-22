import org.apache.avro.Schema;
import org.apache.avro.file.SeekableByteArrayInput;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.BinaryDecoder;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DecoderFactory;

private static GenericRecord deserializeMessage(byte[] message, String schemaText) throws IOException {

    InputStream in = new SeekableByteArrayInput(message);
    Schema schema = new Schema.Parser().parse(schemaText);
    DatumReader<GenericRecord> datumReader = new GenericDatumReader<>(schema);
    BinaryDecoder decoder = DecoderFactory.get().binaryDecoder(in,  null);
    GenericRecord genericRecord = null;
    genericRecord = datumReader.read(genericRecord, decoder);
    in.close();

    return genericRecord;
}