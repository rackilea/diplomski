@Test
 public void serializeAndDeserializeUTF8StringValueExpectingEqual()  {
        String stringValue = "\u0048\u0065\u006C\u006C\u006F";
        String deserializedStringValue = new String(stringValue);

        Throwable thrown = catchThrowable(() -> deserializedStringValue.getBytes("UTF-8"));

        assertThat(thrown).isExactlyInstanceOf(UnsupportedEncodingException.class);
    }