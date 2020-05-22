private class Query4ArgumentMatcher extends ArgumentMatcher<Map<String, Object[]>> {
     private String value;


    public Query4ArgumentMatcher(String value) {

        this.value = value;

    }

    public boolean matches(Object o) {

        if (o instanceof Map) {

            Map<String, Object[]> map = (Map<String, Object[]>) o;


            for (Map.Entry<String, Object[]> m : map.entrySet()) {

                String s = (m.getValue())[0].toString();

                if (value.contentEquals(s)) {

                    return true;

                }

            }

        }

        return false;

    }

}