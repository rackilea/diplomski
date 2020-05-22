<target name="print-epoch">
  <script language="javascript">
  <![CDATA[
    property = project.setProperty("now",Math.floor((new Date()).getTime()/1000));
  ]]>
  </script>
  <echo message="${now}" />
</target>