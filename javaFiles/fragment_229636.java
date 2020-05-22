<copy todir="${pse-layout.dir}/sdk/partnersdk/new-soap-client">
  <fileset dir="samples/soap-client/target/layout">               
    <include name="**/*"/>              
    <exclude name="**/wsdl/**"/>
  </fileset>
</copy>