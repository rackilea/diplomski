import com.google.common.io.BaseEncoding;

String lastFile = "test.csv"
String token = base64Encode(lastFile);

String bucket = "my-bucket"
String prefix = "test"

Storage.Objects.List listObjects = client.objects().list(bucket);
listObjects.setPrefix(prefix);
listObjects.setPageToken(token);
long maxResults = 1;
listObjects.setMaxResults(maxResults);
do {
    Objects objects = listObjects.execute();
    List<StorageObject> items = objects.getItems();

    token = objects.getNextPageToken();
    listObjects.setPageToken(token);
} while (token != null);

private String base64Encode(String path) {
    byte[] encoding;
    byte[] utf8 = path.getBytes(Charsets.UTF_8);
    encoding = new byte[utf8.length + 2];
    encoding[0] = 0x0a;
    encoding[1] = new Byte(String.valueOf(path.length()));
    String s = BaseEncoding.base64().encode(encoding);
    return s;
}