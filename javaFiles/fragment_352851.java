Iterator<?> iterator = myparentHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry myEntry = (Entry) iterator.next();
            System.out.println(myEntry.getKey() + " : ");
            HashMap<Integer, String> childHashMaps = ((HashMap<Integer, String>) myEntry.getValue());
            System.out.println("{");
            for (Map.Entry<Integer, String> childHashMap : childHashMaps.entrySet()) {
                System.out.print(childHashMap.getKey() + " : ");
                System.out.println(childHashMap.getValue());
            }
            System.out.println("}");
        }