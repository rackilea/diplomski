List<Map<String, String>> list = ...;
        for (final Map<String, String> element : list) {
            for (final Entry<String, String> entryElem : element.entrySet()) {
                System.out.println("Key: " + entryElem.getKey());
                System.out.println("Value: " + entryElem.getValue());
            }
        }