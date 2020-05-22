<jr:list xmlns:jr="http://jasperreports.sourceforge.net/jasperreports/components" xsi:schemaLocation="http://jasperreports.sourceforge.net/jasperreports/components http://jasperreports.sourceforge.net/xsd/components.xsd" printOrder="Vertical">
                    <datasetRun subDataset="dataset1">
                        <dataSourceExpression><![CDATA[$P{ds1}]]></dataSourceExpression>
                    </datasetRun>
                    <jr:listContents height="66" width="400">
                        <textField>
                            <reportElement x="10" y="10" width="100" height="20"/>
                            <textElement/>
                            <textFieldExpression><![CDATA[$F{empname}]]></textFieldExpression>
                        </textField>
                    </jr:listContents>
                </jr:list>