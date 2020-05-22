import com.hortonworks.registries.schemaregistry.SchemaMetadataInfo;
import com.hortonworks.registries.schemaregistry.SchemaVersionInfo;
import com.hortonworks.registries.schemaregistry.SchemaVersionKey;
import com.hortonworks.registries.schemaregistry.client.SchemaRegistryClient;

try(SchemaRegistryClient client = new SchemaRegistryClient(this.schemaRegistryConfig)) {
    try {
        Long schemaId = ByteBuffer.wrap(Arrays.copyOfRange(message, 1, 9)).getLong();
        Integer schemaVersion =  ByteBuffer.wrap(Arrays.copyOfRange(message, 9, 13)).getInt();


        SchemaMetadataInfo schemaInfo = client.getSchemaMetadataInfo(schemaId);
        String schemaName = schemaInfo.getSchemaMetadata().getName();

        SchemaVersionInfo schemaVersionInfo = client.getSchemaVersionInfo(
                new SchemaVersionKey(schemaName, schemaVersion));   


        String avroSchema = schemaVersionInfo.getSchemaText();
        byte[] message= Arrays.copyOfRange(message, 13, message.length);
        // Deserialize [...]
    } 
    catch (Exception e) 
    {
        throw new IOException(e.getMessage());
    }
}