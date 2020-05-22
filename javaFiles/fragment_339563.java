public static final Map<String, List<String>> MAP = new HashMap<String, List<String>>();

public static void main(@Nonnull final String[] args)
{
    final List<String> animals = new ArrayList<String>();
    animals.add("cat");
    animals.add("sheep");
    animals.add("dog");
    animals.add("pig");
    animals.add("cow");
    MAP.put("animals", animals);
    System.out.println(MAP);
    final List<String> al = MAP.get("animals");
    System.out.println(al);
}