public class SerializeFinalFields {

        @Test
        public void doTest() throws JsonProcessingException {
            final TestClass t = new TestClass("flag");
            final ObjectMapper om = new ObjectMapper();
            // Older jackson versions:
            // om.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
            // om.setVisibility(
            //      om.getSerializationConfig().getDefaultVisibilityChecker()
            //              .withFieldVisibility(JsonAutoDetect.Visibility.ANY));
            // newer jackson versions:
            om.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);

            final String json = om.writeValueAsString(t);
            System.out.println(json);
        }

    }

    class TestClass {

        private final String myField;

        /* package */ TestClass(final String myField) {
            this.myField = myField;
        }
    }