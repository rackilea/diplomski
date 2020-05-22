MBeanServer connection = ManagementFactory.getPlatformMBeanServer();
Set<ObjectInstance> set = connection.queryMBeans(new ObjectName("java.lang:type=Memory"), null);
ObjectInstance oi = set.iterator().next();
// replace "HeapMemoryUsage" with "NonHeapMemoryUsage" to get non-heap mem
Object attrValue = connection.getAttribute(oi.getObjectName(), "HeapMemoryUsage");
if( !( attrValue instanceof CompositeData ) ) {
    System.out.println( "attribute value is instanceof [" + attrValue.getClass().getName() +
            ", exitting -- must be CompositeData." );
    return;
}
// replace "used" with "max" to get max
System.out.println(((CompositeData)attrValue).get("used").toString());