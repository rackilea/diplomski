public class CharacterMapAssert extends AbstractMapAssert<MapAssert<Character, Integer>, Map<Character, Integer>, Character, Integer> {

    public CharacterMapAssert(Map<Character, Integer> actual) {
        super(actual, CharacterMapAssert.class);
    }

    public static CharacterMapAssert assertThat(Map<Character, Integer> actual) {
        return new CharacterMapAssert(actual);
    }

    public CharacterMapAssert hasNameWithAge(String name, int age) {
        isNotNull();

        for (Map.Entry<Character, Integer> entrySet : actual.entrySet()) {
            if (entrySet.getKey().getName().contains(name) && (int) entrySet.getValue() == age) {
                return this;
            }
        }

        String msg = String.format("entry with name %s and age %s does not exist", name, age);
        throw new AssertionError(msg);
    }

}