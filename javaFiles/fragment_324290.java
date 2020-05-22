String str = "123|00,125|,126|01,|,";
String[] tokens = str.split(",");
Map<Integer, String> flagMap = new HashMap<Integer, String>();

    for (String token: tokens) {
        String[] arr = token.split("[|]");

        if (arr.length == 0) {
            continue;
        }
        if (arr[0].length() > 1) {
            if (arr.length == 2) {
                flagMap.put(Integer.parseInt(arr[0]), arr[1]);
            } else {
                flagMap.put(Integer.parseInt(arr[0]), "");
            }
        }
    }

    System.out.println(flagMap);