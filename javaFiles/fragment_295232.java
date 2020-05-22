<style name="ColoredField">
    <conditionalStyle>
        <conditionExpression><![CDATA[Boolean.valueOf($F{PRODUCT_COST} > 12.0 && $F{PRODUCT_COST} <= 14.0)]]></conditionExpression>
        <style forecolor="#FF0000"/>
    </conditionalStyle>
    <conditionalStyle>
        <conditionExpression><![CDATA[Boolean.valueOf($F{PRODUCT_COST} > 14.0)]]></conditionExpression>
        <style forecolor="#00FF99"/>
    </conditionalStyle>
</style>
 ...
<detail>
    <band height="21" splitType="Stretch">
        <textField>
            <reportElement style="ColoredField" x="78" y="1" width="100" height="20"/>
            <textElement/>
            <textFieldExpression><![CDATA[$F{PRODUCT_NAME}]]></textFieldExpression>
        </textField>