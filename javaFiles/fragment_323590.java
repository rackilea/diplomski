<package name="jasperreport" namespace="/reports" extends="jasperreports-default">
  <action name="myJasperTest" class="[...]JasperReportAction" method="getTestReport">
      <result name="success" type="jasper" >
         <param name="location">/WEB-INF/jasper/${outFile}</param>
         <param name="connection">sqlConnection</param> 
         <param name="reportParameters">reportParams</param>
        <param name="format">${format}</param>

        <param name="imageServletUrl">/servlets/image?image=</param>
    </result>
  </action>
</package>