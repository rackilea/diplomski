/* exception stuff ommitted (for readability and shortness) */
C instanceOfC = new C();

Class<? extends C> clazz = instanceOfC.getClass();
Field f = clazz.getDeclaredField("pm");
f.setAccessible(true);

... = f.get(instanceOfC);  //<-- this will get you the value of `c.pm`