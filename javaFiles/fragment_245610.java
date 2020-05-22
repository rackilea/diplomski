<jr:list xmlns:jr="http://jasperreports.sourceforge.net/jasperreports/components" xsi:schemaLocation="http://jasperreports.sourceforge.net/jasperreports/components http://jasperreports.sourceforge.net/xsd/components.xsd" printOrder="Vertical">
                <datasetRun subDataset="dataset1" uuid="a274a1ab-d0f4-430d-a8c2-d342a20ff672">
                    <connectionExpression><![CDATA[$P{REPORT_CONNECTION}]]></connectionExpression>
                </datasetRun>
                <jr:listContents height="53" width="555">
                    <textField>
                        <reportElement uuid="7dd0769f-d7b6-4620-8e88-1ad3ca607e8d" x="2" y="0" width="100" height="20"/>
                        <textElement/>
                        <textFieldExpression><![CDATA[""+$P{adhist}]]></textFieldExpression>
                    </textField>
                </jr:listContents>
            </jr:list>