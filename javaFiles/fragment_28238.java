<bean id="connectionFactoryLocator" class="org.springframework.social.security.SocialAuthenticationServiceRegistry">
    <property name="authenticationServices">
        <list>
            <bean class="org.springframework.social.facebook.security.FacebookAuthenticationService">
                <constructor-arg value="${facebook.clientId}" />
                <constructor-arg value="${facebook.clientSecret}" />
                <!-- Important: The next property name changed from "scope" to "defaultScope" in 1.1.0.M4 -->
                <property name="scope" value="email" />              
            </bean>
        </list>
    </property>
</bean>