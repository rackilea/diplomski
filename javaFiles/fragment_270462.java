<bean id="myid" class="com.some.BasicWebUI">
  <property name="colsTemplate">
    <map>
      <entry key="NAME">
        <value>
          <![CDATA[<a href="#\{base}/agent/detail?id=#\{row.UID}">#\{row.NAME}</a> ]]>
        </value>
      </entry>
    </map>
  </property>
</bean>