mbs = conn.getMBeanServerConnection();
  ObjectName runtime = new ObjectName(ManagementFactory.RUNTIME_MXBEAN_NAME);
  TabularDataSupport foo = 
    (TabularDataSupport) mbs.getAttribute(runtime, "SystemProperties");
  for (Iterator<Object> it = foo.values().iterator(); 
                      it.hasNext() && null == retVal; ) {
    CompositeDataSupport cds = (CompositeDataSupport) it.next();
    for (Iterator<?> iter = cds.values().iterator() ; 
                   iter.hasNext() && null == retVal ;) {
      if ("file.encoding".equals(iter.next()) && iter.hasNext())
        retVal = iter.next().toString();
    }