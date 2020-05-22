Multimap<String, String> mmap = ArrayListMultimap.create();
mmap.put("Program1", "SubProgramType1");
mmap.put("Program1", "SubProgramType2");
// etc.

mmap.get("Program1")