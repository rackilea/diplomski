// Set the namepace temporarily to "abc"
String oldNamespace = NamespaceManager.get();
NamespaceManager.set("abc");
try {
  ... perform operation using current namespace ...
} finally {
  NamespaceManager.set(oldNamespace);
}