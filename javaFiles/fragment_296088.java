<project>
  <condition property="var1" value="class1">
    <equals arg1="value" arg2="${the_value}"/>
  </condition>
  <condition property="var1" value="class2">
    <not>
      <equals arg1="value" arg2="${the_value}"/>
    </not>
  </condition>
  <echo>the_value: ${the_value}</echo>
  <echo>var1: ${var1}</echo>
</project>