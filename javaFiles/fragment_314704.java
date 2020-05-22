@Document(indexName = "your_index", type = "your_type")
@Mapping(mappingPath = "/mappings/mappings.json")
public class SomeObject{
    String id;
    @Field(type=FieldType.Object, index=FieldIndex.not_analyzed)
    Map<String, String> parameters;
}