final Collection<Object> allowedValues = allowed.values();
final Collection<Object> userDefinedValues = userDefined.values();
userDefinedValues.removeAll(allowedValues);

if (!userDefinedValues.isEmpty()) {
    // Error!
}