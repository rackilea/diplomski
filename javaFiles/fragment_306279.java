HashMap<String, String> myhash = new HashMap<String, String>();
    myhash.put("Cat1", "james");
    myhash.put("Cat2", "adams");
    myhash.put("Cat3", "turk");
    System.out.println(myhash);
    // {Cat3=turk, Cat2=adams, Cat1=james}
    // I Would like : [{Cat3=turk, Cat2=adams, Cat1=james}, {Cat3=turk, Cat2=adams, Cat1=james}]

    ArrayList<HashMap<String, String>> lst = new ArrayList<>();
    lst.add(myhash);
    lst.add(myhash);
    System.out.println(lst); //[{Cat3=turk, Cat2=adams, Cat1=james}, {Cat3=turk, Cat2=adams, Cat1=james}]