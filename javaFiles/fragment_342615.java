// Load default/allowed properties from a resource file
final Properties allowed = new Properties();
properties.load(allowedInput);

// Load user-defined properties from a file
final Properties userDefined = new Properties();
properties.load(userDefinedInput);

// Remove all the keys from the user-defined Property
// that match with the allowed one. 
final Collection<Object> userDefinedCopy = new HashSet<>(userDefined.keySet());
userDefinedCopy.removeAll(allowed.keySet());

// If the key Set is not empty, it means the user added
// invalid or not allowed keys
if (!userDefined.isEmpty()) {
    // Error!
}