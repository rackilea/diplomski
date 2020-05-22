Enumeration attrNames = oldSession.getAttributeNames();
Properties props = new Properties();

if (attrNames != null)
{
  while (attrNames.hasMoreElements())
  {
    String key = (String) attrNames.nextElement();
    props.put(key, oldSession.getAttribute(key));
  }
  // Invalidating previous session
  oldSession.invalidate();
  // Generate new session
  HttpSession newSession = request.getSession(true);
  attrNames = props.keys();
  while (attrNames.hasMoreElements())
  {
    String key = (String) attrNames.nextElement();
    newSession.setAttribute(key, props.get(key));
  }
}