<camelContext xmlns="http://camel.apache.org/schema/blueprint">
    <route id="example">
        <from uri="cxf:bean:myListenerEndpoint?dataFormat=POJO&amp;synchronous=true" />
        <log message="The expected operation is :: ${headers.operationName}" />
        <choice>
            <when>
                <simple>${headers.operationName} == 'RegisterUser'</simple>
                    <bean ref="processor" method="processMessage"/>
                <to uri="xslt:file:resources/service/2.0.0/UserRegistration.xsl"/>
            </when>
            <when>
                <simple>${headers.operationName} == 'UpdateUser'</simple>
                <!-- Do the update user logic here -->
                <bean ref="processor" method="updateUser" />
            </when>
        </choice>
    <to uri="cxf:bean:myTargetEndpoint"/>
    </route>
</camelContext>