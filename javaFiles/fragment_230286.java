FUNCTION GatewayClientPoolHA (
      DAUTAddresses         IN daut_addresses_type,
      DAUTPortArray         IN daut_port_type,
      sslKeystorePath       IN VARCHAR2,
      sslKeystorePass       IN VARCHAR2
 ) RETURN NUMBER IS LANGUAGE JAVA
   NAME daut.GatewayClientPoolHA(java.lang.String[], int[], java.lang.String, java.lang.String) return int';