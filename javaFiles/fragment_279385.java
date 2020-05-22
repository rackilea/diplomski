public static final void flushJaasCache(String securityDomain){  
      try {  
           javax.management.MBeanServerConnection mbeanServerConnection = java.lang.management.ManagementFactory  
                     .getPlatformMBeanServer();  
           javax.management.ObjectName mbeanName = new javax.management.ObjectName("jboss.as:subsystem=security,security-domain="+securityDomain);  
           mbeanServerConnection.invoke(mbeanName, "flushCache", null, null);  
      } catch (Exception e) {  
           throw new SecurityException(e);  
      }  
}