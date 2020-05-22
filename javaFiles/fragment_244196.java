<jr:table xmlns:jr="http://jasperreports.sourceforge.net/jasperreports/components" xsi:schemaLocation="http://jasperreports.sourceforge.net/jasperreports/components http://jasperreports.sourceforge.net/xsd/components.xsd">
    <datasetRun subDataset="BillItemsDataSet" uuid="ccd44e17-2c5d-417c-b4a7-554d197ce483">
        <connectionExpression><![CDATA[$P{REPORT_CONNECTION}]]></connectionExpression>
        <datasetParameter name="billIds">
            <datasetParameterExpression><![CDATA[$P{billIds}]]></datasetParameterExpression>
        </datasetParameter>
    </datasetRun>