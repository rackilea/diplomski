<bean id="redisConnectionFactory" class="org.springframework.data.redis.connection.jedis.JedisConnectionFactory">
    <property name="port" value="${app.redis.port}" />
    <property name="hostName" value="${app.redis.hostname}" />
</bean>

<context:annotation-config />
<bean
    class="org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration"/>