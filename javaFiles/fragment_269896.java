@Basic
@Column(name = "PARSED_DATA")
@Lob
public byte[] getParsedData() {
    return parsedData;
}