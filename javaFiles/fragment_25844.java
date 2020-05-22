<jee:jndi-lookup id="handlersDest"  jndi-name="$handlersDest">
    <jee:environment>
        java.naming.factory.initial = ${jndi.jms.naming.factory.initial}
        java.naming.provider.url = ${jndi.jms.naming.url}
        queue.handlersDest = handlersDest
    </jee:environment>
</jee:jndi-lookup>