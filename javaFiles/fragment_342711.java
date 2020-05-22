<bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
    <property name="locations">
        <list>
        <value>file:${user.dir}/PATH...</value>  
        <value>file:${user.dir}/PATH...</value>
        </list>
    </property>