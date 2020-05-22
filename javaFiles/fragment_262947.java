@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "file", "files", "data" })
public class FileWithObject<T> {

    @JsonProperty("file")
    private MultipartFile file;
    @JsonProperty("files")
    private List<MultipartFile> files;
    @JsonRawValue
    @JsonProperty("data")
    private T data;

    // work like (meta-data)
    List<FileWithObject> rawData;
    // getter setter
}