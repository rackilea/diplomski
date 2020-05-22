public static void main(String[] args) throws ParseException {
    List<Info> local = new ArrayList<>();
    local.add(new Info(1,"msg1",false));
    local.add(new Info(2,"msgTwo",false));
    local.add(new Info(3,"msg3",true));
    local.add(new Info(4,"msg4",true));


    List<Info> global = new ArrayList<>();
    global.add(new Info(1,"msg1",false));
    global.add(new Info(2,"msg2",false));
    global.add(new Info(3,"msg3",false));
    global.add(new Info(4,"msg5",true));

    Map<Integer, Info> map = new HashMap<>();

    for (Info info : global) {
        if (!map.containsKey(info.id)) {
            map.put(info.id, info);
        }
    }

    for (Info info : local) {
        if (map.containsKey(info.id)){
            map.get(info.id).isFavor = info.isFavor;
        }
    }

    System.out.println(map.values());
}