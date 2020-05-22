<channel-definition id="my-streaming-amf" class="mx.messaging.channels.StreamingAMFChannel">
        <endpoint url="http://{server.name}:{server.port}/{context.root}/messagebroker/streamingamf" class="flex.messaging.endpoints.StreamingAMFEndpoint"/>
        <properties>
             <!-- you don't need to set all these properties, this is just what we set, included for illustration, only -->
            <idle-timeout-minutes>0</idle-timeout-minutes>
            <max-streaming-clients>10</max-streaming-clients>
                <server-to-client-heartbeat-millis>5000</server-to-client-heartbeat-millis>
            <user-agent-settings>
                <user-agent match-on="Safari" kickstart-bytes="2048" max-streaming-connections-per-session="10"/>  
                <user-agent match-on="MSIE" kickstart-bytes="2048" max-streaming-connections-per-session="15"/> 
                <user-agent match-on="Firefox" kickstart-bytes="2048" max-streaming-connections-per-session="10"/>
            </user-agent-settings>
        </properties>
    </channel-definition>