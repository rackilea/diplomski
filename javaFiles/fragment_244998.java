Field f1 = m.getClass().getDeclaredField("table");
f1.setAccessible(true);
int capacity = f1.get(m).length;

Field f2 = m.getClass().getDeclaredField("threshold");
f2.setAccessible(true);
int currentLoadFactor = f2.get(m);