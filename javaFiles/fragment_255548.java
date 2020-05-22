Map hashMap= new HashMap();
            Map weakHashMap = new WeakHashMap();

            String keyHashMap = new String("keyHashMap");
            String keyWeakHashMap = new String("keyWeakHashMap");

            hashMap.put(keyHashMap, "helloHash");
            weakHashMap.put(keyWeakHashMap, "helloWeakHash");
            System.out.println("Before: hash map value:"+hashMap.get("keyHashMap")+" and weak hash map value:"+weakHashMap.get("keyWeakHashMap"));

            keyHashMap = null;
            keyWeakHashMap = null;

            System.gc();  

            System.out.println("After: hash map value:"+hashMap.get("keyHashMap")+" and weak hash map value:"+weakHashMap.get("keyWeakHashMap"));