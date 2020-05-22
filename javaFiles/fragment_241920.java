for (int i = 0; i < listSuper.size(); i++) {
        ArrayList<HashMap<String, String>> listInner1 = listSuper.get(i);
        for (HashMap<String, String> map : listInner1) {
            for (Map.Entry<String, String> entrySet : map.entrySet()) {
                System.out.println("key = " + entrySet.getKey());
                System.out.println("value = " + entrySet.getValue());
            }
        }
    }