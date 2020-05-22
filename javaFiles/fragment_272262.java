public class DaoFactoryCreator {
    public static DaoFactory createDaoFactory(List daos) {
        ... this is the factory method, do something here and return it
    }
}

<bean id="daoFactory" class="com.javalobby.tnt.spring.DaoFactoryCreator" factory-method="createDaoFactory" />
    <constructor-arg>
        <value>
            <list>
                <ref bean="dao1"/>
                <ref bean="dao2"/>
                <ref bean="dao3"/>
            </list>
        </value>
    </constructor-arg>
</bean>