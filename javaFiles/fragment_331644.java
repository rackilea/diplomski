<flow name="add-correlation-id">
        <scripting:component doc:name="Script">
        <scripting:script engine="groovy">
            <![CDATA[
                String correlationId=message.getInboundProperty('x-request-id');
                if(correlationId==null || correlationId.length() == 0){
                    correlationId = java.util.UUID.randomUUID().toString();
                }
                message.setSessionProperty('requestID',correlationId);
                org.apache.log4j.MDC.put('x-request-id',correlationId);
            ]]>
        </scripting:script>
    </scripting:component>
</flow>