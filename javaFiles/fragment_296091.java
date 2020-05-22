<project>
  <condition property="var1" value="class1" else="class2">
    <equals arg1="value" arg2="${the_value}"/>
  </condition>
  <echo>the_value: ${the_value}</echo>
  <echo>var1: ${var1}</echo>
</project>