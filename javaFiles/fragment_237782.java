DEKey dk = new DEKey(service.getKeys(), id);

List<DEKey> list = new ArrayList<DEKey>();
list.add (dk);

DEClient deClient = new DEClient(list);