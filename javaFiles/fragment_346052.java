public static final String abc="https://127.0.0.1:9443/api/am/store/v0.10/apis/058d2896-9a67-454c-95fc-8bec697d08c9/documents/058d2896-9a67-454c-9aac-8bec697d08c9";
public static final String SWAGGER_BASE_UUID_REGEX = "\\p{XDigit}{8}-\\p{XDigit}{4}-\\p{XDigit}{4}-\\p{XDigit}{4}-\\p{XDigit}{12}";

public static void main (String[] args) throws java.lang.Exception
{
    Pattern pairRegex = Pattern.compile(SWAGGER_BASE_UUID_REGEX);
    Matcher matcher = pairRegex.matcher(abc);
    while (matcher.find()) {
        String a = matcher.group(0);
        System.out.println(a);
    }
}