Method method = null;
for (Method m : c.getDeclaredMethods()) {
    if (m.getName().equals(callingMethodName)) {
        method = m;
        break;
    }
}
// variable "method" is the first that matched name, or null if not found