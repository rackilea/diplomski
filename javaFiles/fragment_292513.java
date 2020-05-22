try
{
    MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
    ObjectName name = new ObjectName("wro4j-ROOT:type=WroConfiguration");
    mbs.invoke(name, "reloadCache", null, null);
    mbs.invoke(name, "reloadModel", null, null);
}
catch (InstanceNotFoundException e)
{
    logger.warn("Could not find wro4j MBean. It has not been initiated yet");
}
catch (Exception e)
{
    logger.error(e);
}