@RunWith(JUnit4.class)
public class Sample {

    @Test
    public void testName() throws Exception {
        SampleClass sample = new SampleClass("value1", "value2", new SubClass("value4", "value5", new SubSubClass("value7")));
        new ObjectMapper().writeValue(System.out, sample);
    }

    @JsonAutoDetect(fieldVisibility=Visibility.ANY)
    public static class SampleClass {
        private String prop1;
        private String prop2;
        @JsonUnwrapped
        private SubClass prop3;

        public SampleClass(String prop1, String prop2, SubClass prop3) {
            this.prop1 = prop1;
            this.prop2 = prop2;
            this.prop3 = prop3;
        }
    }
    @JsonAutoDetect(fieldVisibility=Visibility.ANY)
    public static class SubClass {
        private String prop4;
        private String prop5;
        @JsonUnwrapped
        private SubSubClass prop6;
        public SubClass(String prop4, String prop5, SubSubClass prop6) {
            this.prop4 = prop4;
            this.prop5 = prop5;
            this.prop6 = prop6;
        }

    }
    @JsonAutoDetect(fieldVisibility=Visibility.ANY)
    public static class SubSubClass{
        private String prop7;

        public SubSubClass(String prop7) {
            this.prop7 = prop7;
        }
    }
}