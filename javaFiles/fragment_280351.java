JSONObject o = new JSONObject("{ \"a1\": [ false, true, false, true ], \"a2\": [1,2,3,4] }");
    JSONArray a1 = o.getJSONArray("a1");
    JSONArray a2 = o.getJSONArray("a2");
    if (a1.length() > 0) {
        if (a1.get(0) instanceof Boolean) {
            System.out.println("a1 is Boolean array");
        } else if (a1.get(0) instanceof Integer) {
            System.out.println("a1 is Integer array");
        } else {
            System.out.println("a1 is some other type");
        }
    }
    if (a2.length() > 0) {
        if (a2.get(0) instanceof Boolean) {
            System.out.println("a2 is Boolean array");
        } else if (a2.get(0) instanceof Integer) {
            System.out.println("a2 is Integer array");
        } else {
            System.out.println("a2 is some other type");
        }
    }