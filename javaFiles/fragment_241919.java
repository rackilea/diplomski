List<ArrayList<HashMap<String, String>>> listSuper = new ArrayList<>();//List of label in your xml

    ArrayList<HashMap<String, String>> listInner = new ArrayList<>();//Correspond to a label in your xml

    HashMap<String, String> hashMapLblMs = new HashMap<>();
    hashMapLblMs.put("EN", "Morning Sync");
    hashMapLblMs.put("DE", "Morgan Sync");
    listInner.add(hashMapLblMs);

    HashMap<String, String> hashMaplblES = new HashMap<>();
    hashMaplblES.put("EN", "Evening Sync");
    hashMaplblES.put("DE", "Sync Abend");
    listInner.add(hashMaplblES);

    listSuper.add(listInner);