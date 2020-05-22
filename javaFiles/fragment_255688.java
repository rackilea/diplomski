public class QuotationHttpResult<T> {
    private int code;

    private Result<T> result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Result<T> getResult() {
        return result;
    }

    public void setResult(Result<T> result) {
        this.result = result;
    }

    public static class Result<T>{
        private T data;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}

public class MyClass {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public static void main(String[] args) throws IOException {
    String json = " {\"code\": 0,\n" +
            "     \"result\": {\n" +
            "         \"data\": [\n" +
            "            {\n" +
            "            \"id\": \"1000\",\n" +
            "            \"name\": \"tecent\"\n" +
            "            }, \n" +
            "            {\n" +
            "            \"id\": \"1001\",\n" +
            "            \"name\": \"alibaba\"\n" +
            "            }\n" +
            "         ]\n" +
            "       }\n" +
            "    }";
    ObjectMapper mapper = new ObjectMapper();
    QuotationHttpResult<MyClass> result = mapper.readValue(json,new TypeReference<QuotationHttpResult<List<MyClass>>>() {});
    System.out.println(result);
}