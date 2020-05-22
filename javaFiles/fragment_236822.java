<cxf:rsServer id="messageServer"
    address="http://0.0.0.0:${rest.service.message.port}"
    serviceClass="com.example.service.MyService">
    <cxf:providers>
        <bean class="org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider" />
    </cxf:providers>
</cxf:rsServer>