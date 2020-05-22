HazelcastInstance hz = Hazelcast.newHazelcastInstance();

IMap<String, Collection<String>> store = instance.getMap("store");

Collection<String> val = new HashSet<>();
val.add("a");

store.put("a", val);

Collection<String> oldVal = store.get("a");

byte[] dataOld = ((HazelcastInstanceProxy) hz).getSerializationService().toBytes(oldVal);
byte[] dataNew = ((HazelcastInstanceProxy) hz).getSerializationService().toBytes(val);

System.out.println(Arrays.equals(dataNew, dataOld));