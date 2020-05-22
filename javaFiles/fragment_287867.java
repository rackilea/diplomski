<property name="jpaProperties">
    <map>
        <entry key="hibernate.hbm2ddl.auto" 
            value="#{${com.github.dpeger.jpa.validate}?'validate':'none'}" />
        ...
    </map>
</property>