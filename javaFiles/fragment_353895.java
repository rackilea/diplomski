@Test
    public void compareJsonStrIgnoringDiffInArray() throws JSONException {
        String errorMsg = "";
        String expectedJsonStr = "{\"anArray\": [{\"id\": \"valueA\"}, {\"colour\": \"Blue\"}]}";
        String actualJsonStr = "{\"anArray\": [{\"id\": \"valueB\"}, {\"colour\": \"Blue\"}]}";

        //Create custom comparator which compares two json strings but ignores reporting any differences for anArray[n].id values
        //as they are a tolerated difference

        ArrayValueMatcher<Object> arrValMatch = new ArrayValueMatcher<>(new CustomComparator(
                JSONCompareMode.NON_EXTENSIBLE,
                new Customization("anArray[*].id", (o1, o2) -> true)));

        Customization arrayValueMatchCustomization = new Customization("anArray", arrValMatch);
        CustomComparator customArrayValueComparator = new CustomComparator(
                JSONCompareMode.NON_EXTENSIBLE, 
                arrayValueMatchCustomization);
        JSONAssert.assertEquals(expectedJsonStr, actualJsonStr, customArrayValueComparator);
    }