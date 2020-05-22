public class Test {

    public static void main(String args[]) {
        String input = "{\"attribute1\":\"value1\",\"attribute2\":\"value2\",\"attribute3\":{\"attribute3a\":\"value3a\",\"attribute3b\":\"value3b\"}},{\"attribute1\":\"value1\",\"attribute2\":\"value2\",\"attribute3\":{\"attribute3a\":\"value3a\",\"attribute3b\":\"value3b\"}},{\"attribute1\":\"value1\",\"attribute2\":\"value2\",\"attribute3\":{\"attribute3a\":\"value3a\",\"attribute3b\":\"value3b\"}}";
        String[] output = input.split("},");
        for(String s: output) {
            System.out.println(s+"}");
        }
    }

}