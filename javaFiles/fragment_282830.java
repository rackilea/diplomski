public static void main(String[] args) {

    Map<String, Boolean> states = new HashMap<String, Boolean>();
    states.put("b_StorageAvailable", true);
    states.put("b_StorageWritable", true);

    if(states.get("b_StorageAvailable")){ // works fine!
        System.out.println("storage is available!");
    }

    Map states2 = new HashMap<String, Boolean>(); // untyped!
    states.put("b_StorageAvailable", true);
    states.put("b_StorageWritable", true);
    if(states2.get("b_StorageAvailable")){ // Type mismatch: cannot convert from Object to boolean
        System.out.println("storage is available!");
    }

}