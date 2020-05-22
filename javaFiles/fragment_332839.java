Field types = TypeFactory.class.getDeclaredField("BASIC_TYPES");
types.setAccessible(true);
Object bt = types.get(null);
Field m = bt.getClass().getDeclaredField("m");
m.setAccessible(true);
Map val = (Map) m.get(bt);
val.put(String.class.getName(), new MyType());