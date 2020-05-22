final Properties allowed = new Properties();
// Load

final Properties userDefined = new Properties();
// Load

final long count =
    userDefined.entrySet()
               .stream()
               .filter(e -> {
                  final Object o = allowed.get(e.getKey());

                  // If 'o' is null, the user-defined property is out of bounds.
                  // If 'o' is present ('o' represents the valid value), but it doesn't
                  // match with the user-defined value, the property is wrong

                  return o == null || !Objects.equals(o, e.getValue());
               }).count();

if (count != 0) {
   // Error!
}