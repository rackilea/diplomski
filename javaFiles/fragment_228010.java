<bean id="yourreport" class="org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView">
    <property name="headers">
        <map>
            <entry key="Content-Disposition" value="attachment; profile.pdf" />
        </map>
    <property>
</bean>