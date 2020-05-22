try
{
  final Pattern aMethodNamePattern = Pattern.compile("foo[Bb]ar");
  final List<Method> someMethods = aClass.getDeclaredMethods();
  final List<Method> someCompliantMethods = new ArrayList<Method>();
  for(final Method aMethod: someMethods)
  {
    final String aMethodName = aMethod.getName();
    final Matcher aMethodNameMatcher = aMethodNamePattern.getMatcher(aMethodName);
    if(aMethodNameMatcher.matches() == true)
    {
       someCompliantMethods.add(aMethod);
    }
}
catch(...) // catch all exceptions like SecurityException, IllegalAccessException, ...