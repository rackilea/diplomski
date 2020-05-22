<int-mongodb:inbound-channel-adapter id="inboundAdapterWithOnSuccessDisposition"
                                     channel="replyChannel"
                                     query="{'name' : 'Bob'}"
                                     auto-startup="false">

    <int:poller fixed-delay="200" max-messages-per-poll="1">
        <int:advice-chain  synchronization-factory="syncFactory">
            <bean
                    class="org.springframework.integration.mongodb.config.MongoDbInboundChannelAdapterIntegrationTests.TestMessageSourceAdvice" />
            <tx:advice>
                <tx:attributes>
                    <tx:method name="*" />
                </tx:attributes>
            </tx:advice>
        </int:advice-chain>
    </int:poller>
</int-mongodb:inbound-channel-adapter>

<int:transaction-synchronization-factory id="syncFactory">
    <int:before-commit expression="@documentCleaner.remove(#mongoTemplate, payload, headers.mongo_collectionName)"/>
</int:transaction-synchronization-factory>

<bean id="transactionManager" class="org.springframework.integration.transaction.PseudoTransactionManager" />