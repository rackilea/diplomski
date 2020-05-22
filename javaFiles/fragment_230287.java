CREATE TYPE daut_addresses_type IS TABLE OF VARCHAR2(50)
/
CREATE TYPE daut_port_type IS TABLE OF NUMBER
/

CREATE OR REPLACE PACKAGE daut_2fa IS

  FUNCTION GatewayClientPoolHA (
      DAUTAddresses         IN daut_addresses_type,
      DAUTPortArray         IN daut_port_type,
      sslKeystorePath       IN VARCHAR2,
      sslKeystorePass       IN VARCHAR2
 ) RETURN NUMBER;


END daut_2fa;
/

CREATE OR REPLACE PACKAGE BODY daut_2fa IS

  FUNCTION GatewayClientPoolHA (
      DAUTAddresses         IN daut_addresses_type,
      DAUTPortArray         IN daut_port_type,
      sslKeystorePath       IN VARCHAR2,
      sslKeystorePass       IN VARCHAR2
 ) RETURN NUMBER IS LANGUAGE JAVA
   NAME 'daut.GatewayClientPoolHA(java.lang.String[], int[], java.lang.String, java.lang.String) return int';

END daut_2fa;
/

Package body DAUT_2FA compiled

SHOW ERRORS

No errors.