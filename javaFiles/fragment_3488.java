Collection<Method> candidates = new ArrayList<Method>();
String target = "add" + propertyName;
for (Method m : model.getClass().getMethods()) {
  if (target.equals(m.getName())) {
    Class<?>[] params = m.getParameterTypes();
    if (params.length == 1) {
      if (params[0].isInstance(newValue))
        candidates.add(m);
    }
  }
}
/* Now see how many matches you have... if there's exactly one, use it. */