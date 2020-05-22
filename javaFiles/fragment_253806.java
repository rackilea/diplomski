EnumMap<Foo, String> numberEnumMapping = new EnumMap<>(Foo.class);
numberEnumMapping.put(Foo.BAR1, "1");
numberEnumMapping.put(Foo.BAR2, "2");
numberEnumMapping.put(Foo.BAR3, "3");
Map<Foo, String> numberMapping = Collections.unmodifiableMap(numberEnumMapping);

EnumMap<Foo, String> letterEnumMapping = new EnumMap<>(Foo.class);
letterEnumMapping.put(Foo.BAR1, "x");
letterEnumMapping.put(Foo.BAR2, "y");
letterEnumMapping.put(Foo.BAR3, "z");
Map<Foo, String> letterMapping = Collections.unmodifiableMap(letterEnumMapping);

// ... More mappings.