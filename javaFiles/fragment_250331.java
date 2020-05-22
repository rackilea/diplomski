DynamicType.Builder builder = new ByteBuddy().subclass(Object.class);
    List<String> fields = Lists.newArrayList("a", "b", "c");

    for (String str : fields) {
        builder = builder.defineField(str, MyClass.class, Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC | Opcodes.ACC_FINAL);
    }

    DynamicType.Loaded loaded = builder.make().load(ByteBuddyTest.class.getClassLoader(), ClassLoadingStrategy.Default.INJECTION);

    Object obj = loaded.getLoaded().getConstructor().newInstance();
    System.out.println(obj.getClass().getField("a"));
    System.out.println(obj.getClass().getField("c"));