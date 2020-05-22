<bean id="flatFileItemWriter" class="org.springframework.batch.item.file.FlatFileItemWriter" scope="step" >
    <property name="resource"
        value="file:csv/outputs/users.processed#{stepExecutionContext[fromId]}-#{stepExecutionContext[toId]}.csv" />

   <!-- ******* remove this line ***** --><property name="appendAllowed" value="false" /> 

    <property name="lineAggregator">
        <bean class="org.springframework.batch.item.file.transform.DelimitedLineAggregator">
            <property name="delimiter" value="," />
            <property name="fieldExtractor">
                <bean class="org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor">
                    <property name="names" value="id, username, password, age" />
                </bean>
            </property>
        </bean>
    </property>
</bean>