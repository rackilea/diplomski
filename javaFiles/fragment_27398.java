<textField>
     <reportElement x="0" y="0" width="100" height="20" uuid="eac93a84-7901-4205-b09c-556d48dc05e1">
        <printWhenExpression><![CDATA[new java.lang.Boolean($F{MO_DATECREATED}!=null && $F{MO_DATECOMPLETED}!=null)]]></printWhenExpression>
    </reportElement>
    <textFieldExpression><![CDATA[(new java.text.SimpleDateFormat("mm/dd/yy hh:mm a").parse($F{MO_DATECOMPLETED}).getTime()-new java.text.SimpleDateFormat("mm/dd/yy hh:mm a").parse($F{MO_DATECREATED}).getTime())/(1000*60*60) + " hours"]]></textFieldExpression>
</textField>