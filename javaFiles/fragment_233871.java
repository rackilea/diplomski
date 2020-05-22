Field reader = MyClass.class.getDeclaredField("reader");
reader.setAccessible(true);
MyClass mc = new MyClass();
StringReader stringReader = new StringReader("some string");
BufferedReader readerToSet = new BufferedReader(stringReader);
reader.set(mc, readerToSet);
mc.methodToTest();