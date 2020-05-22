<property name="jpaProperties">
    <map>
        <entry key="hibernate.hbm2ddl.auto" 
            value="#{props['com.github.dpeger.jpa.validate']?'validate':'none'}" />
        ...
    </map>
</property>