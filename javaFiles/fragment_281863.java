0 bytes written {org.apache.http.nio.reactor.ssl.SSLIOSession}

[2018-08-28 00:34:45,784] DEBUG -  http-outgoing-397: Produce output 
{org.apache.synapse.transport.http.conn.LoggingNHttpClientConnection}

[2018-08-28 00:34:45,784] DEBUG -  I/O session http-outgoing-397-250
192.168.3.216:54504<->192.168.3.216:9443[ACTIVE][rw:w][ACTIVE][rw] . 
[NOT_HANDSHAKING][0][0][1189][0]: 1105 bytes written 
{org.apache.http.nio.reactor.ssl.SSLIOSession}

[2018-08-28 00:34:45,785] DEBUG -  HTTPS-Sender I/O dispatcher-4 << "POST 
/api-application-registration/register/tenants?            
tenantDomain=carbon.super&applicationName=ios-webapp-carbon.super 
HTTP/1.1[\r][\n]" {org.apache.synapse.transport.http.wire}

[2018-08-28 00:34:45,785] DEBUG -  HTTPS-Sender I/O dispatcher-4 << "X-JWT- 
Assertion: eyJhbGciOiJSUzI1NiJ9.eyJzdWI7LY-mV2P5q-2q-  
{org.apache.synapse.transport.http.wire}

[2018-08-28 00:34:45,785] DEBUG -  HTTPS-Sender I/O dispatcher-4 << "Content- 
Type: application/json; charset=UTF-8[\r][\n]" 
{org.apache.synapse.transport.http.wire}

[2018-08-28 00:34:45,785] DEBUG -  HTTPS-Sender I/O dispatcher-4 << 
"Transfer-Encoding: chunked[\r][\n]" {org.apache.synapse.transport.http.wire}

[2018-08-28 00:34:45,785] DEBUG -  HTTPS-Sender I/O dispatcher-4 << "Host: 
IOT server:9443[\r][\n]" {org.apache.synapse.transport.http.wire}

[2018-08-28 00:34:45,785] DEBUG -  HTTPS-Sender I/O dispatcher-4 << 
"Connection: Keep-Alive[\r][\n]" {org.apache.synapse.transport.http.wire}

[2018-08-28 00:34:45,785] DEBUG -  HTTPS-Sender I/O dispatcher-4 << "User- 
Agent: Synapse-PT-HttpComponents-NIO[\r][\n]" 
{org.apache.synapse.transport.http.wire}

[2018-08-28 00:34:45,785] DEBUG -  HTTPS-Sender I/O dispatcher-4 << "[\r] . 
[\n]" {org.apache.synapse.transport.http.wire}

[2018-08-28 00:34:45,785] DEBUG -  HTTPS-Sender I/O dispatcher-4 << "0[\r] . 
[\n]" {org.apache.synapse.transport.http.wire}

[2018-08-28 00:34:45,785] DEBUG -  HTTPS-Sender I/O dispatcher-4 << "[\r] . 
[\n]" {org.apache.synapse.transport.http.wire}

[2018-08-28 00:34:45,786] DEBUG -  I/O session http-outgoing-397-250
192.168.3.216:54504<->192.168.3.216:9443[ACTIVE][rw:w][ACTIVE][rw] . 
[NOT_HANDSHAKING][0][0][1189][0]: Clear event [w] 
{org.apache.http.nio.reactor.ssl.SSLIOSession}

[2018-08-28 00:34:45,786] DEBUG -  Adding tenant: -1234, isTenantLoaded: 
false {org.wso2.carbon.registry.indexing.internal.IndexingServiceComponent}

[2018-08-28 00:34:45,786] DEBUG -  Size of initializedTenants after adding 
tenant -1234: 1 
{org.wso2.carbon.registry.indexing.internal.IndexingServiceComponent}

[2018-08-28 00:34:45,788] DEBUG -  Failed to authorize incoming request , API 
: %2Fapi-application-registration%2Fregister%2Ftenants 
{org.wso2.carbon.webapp.authenticator.framework.WebappAuthenticationValve}

[2018-08-28 00:34:45,788] DEBUG -  http-outgoing-397: Consume input 
{org.apache.synapse.transport.http.conn.LoggingNHttpClientConnection}

[2018-08-28 00:34:45,788] DEBUG -  I/O session http-outgoing-397-250
192.168.3.216:54504<->192.168.3.216:9443[ACTIVE][r:r][ACTIVE][r] . 
[NOT_HANDSHAKING][0][0][0][0]: 195 bytes read 
{org.apache.http.nio.reactor.ssl.SSLIOSession}

[2018-08-28 00:34:45,789] DEBUG -  HTTPS-Sender I/O dispatcher-4 >> "HTTP/1.1 
401 Unauthorized[\r][\n]" {org.apache.synapse.transport.http.wire}

[2018-08-28 00:34:45,789] DEBUG -  HTTPS-Sender I/O dispatcher-4 >> "Content- 
Type: application/xml;charset=UTF-8[\r][\n]" 
{org.apache.synapse.transport.http.wire}

[2018-08-28 00:34:45,789] DEBUG -  HTTPS-Sender I/O dispatcher-4 >> "Content- 
Length: 36[\r][\n]" {org.apache.synapse.transport.http.wire}

[2018-08-28 00:34:45,789] DEBUG -  HTTPS-Sender I/O dispatcher-4 >> "Date: 
Tue, 28 Aug 2018 07:34:45 GMT[\r][\n]" 
{org.apache.synapse.transport.http.wire}

[2018-08-28 00:34:45,789] DEBUG -  HTTPS-Sender I/O dispatcher-4 >> "Server: 
WSO2 Carbon Server[\r][\n]" {org.apache.synapse.transport.http.wire}

[2018-08-28 00:34:45,789] DEBUG -  HTTPS-Sender I/O dispatcher-4 >> "[\r] . 
[\n]" {org.apache.synapse.transport.http.wire}

[2018-08-28 00:34:45,789] DEBUG -  HTTPS-Sender I/O dispatcher-4 >> "Failed 
to authorize incoming request" {org.apache.synapse.transport.http.wire}

[2018-08-28 00:34:45,789] DEBUG -  http-outgoing-397 << HTTP/1.1 401 
Unauthorized {org.apache.synapse.transport.http.headers}

[2018-08-28 00:34:45,789] DEBUG -  http-outgoing-397 << Content-Type: 
application/xml;charset=UTF-8 {org.apache.synapse.transport.http.headers}

[2018-08-28 00:34:45,789] DEBUG -  http-outgoing-397 << Content-Length: 36 
{org.apache.synapse.transport.http.headers}

[2018-08-28 00:34:45,790] DEBUG -  http-outgoing-397 << Date: Tue, 28 Aug 
2018 07:34:45 GMT {org.apache.synapse.transport.http.headers}

[2018-08-28 00:34:45,790] DEBUG -  http-outgoing-397 << Server: WSO2 Carbon 
Server {org.apache.synapse.transport.http.headers}

[2018-08-28 00:34:45,790] DEBUG -  I/O session http-outgoing-397-250
192.168.3.216:54504<->192.168.3.216:9443[ACTIVE][r:r][ACTIVE][r] . 
[NOT_HANDSHAKING][0][0][0][0]: Set attribute RES_HEADER_ARRIVAL_TIME 
{org.apache.http.nio.reactor.ssl.SSLIOSession}

[2018-08-28 00:34:45,790] DEBUG -  I/O session http-outgoing-397-250
192.168.3.216:54504<->192.168.3.216:9443[ACTIVE][r:r][ACTIVE][r] . 
[NOT_HANDSHAKING]    [0][0][0][0]: Set attribute 
RES_FROM_BACKEND_READ_START_TIME 
{org.apache.http.nio.reactor.ssl.SSLIOSession}

[2018-08-28 00:34:45,790] DEBUG -  I/O session http-incoming-860-249
192.168.3.216:8243<->192.168.3.216:41245[ACTIVE][:r][ACTIVE][] . 
[NOT_HANDSHAKING] . 
[0][0][0][0]: Set attribute CLIENT_WORKER_INIT_TIME 
{org.apache.http.nio.reactor.ssl.SSLIOSession}

[2018-08-28 00:34:45,790] DEBUG -  getAction (null) from 
org.apache.axis2.client.Options@5314693d {org.apache.axis2.client.Options}

[2018-08-28 00:34:45,790] DEBUG -  Old SoapAction is (null) 
{org.apache.axis2.context.MessageContext}