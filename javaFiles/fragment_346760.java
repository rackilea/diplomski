for (Integer num : handicapMap.keySet()) {
        System.out.print("Key : " + String.valueOf(num) + " Values:");
        for (String player : handicapMap.get(num)) {
            System.out.print(" " + player + " ");    
        }
        System.out.println();
    }