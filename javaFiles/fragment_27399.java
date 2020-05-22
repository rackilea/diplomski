<textField>
     <reportElement x="0" y="0" width="100" height="20" uuid="eac93a84-7901-4205-b09c-556d48dc05e1">
        <printWhenExpression><![CDATA[new java.lang.Boolean($F{MO_DATECREATED}!=null && $F{MO_DATECOMPLETED}!=null)]]></printWhenExpression>
    </reportElement>
    <textFieldExpression><![CDATA[($F{MO_DATECOMPLETED}.getTime()-$F{MO_DATECREATED}.getTime()) / (24* 60 * 60 * 1000)  + " days " +($F{MO_DATECOMPLETED}.getTime()-$F{MO_DATECREATED}.getTime()) / (60 * 60 * 1000) % 24 + " hours " +  ($F{MO_DATECOMPLETED}.getTime()-$F{MO_DATECREATED}.getTime()) / (60 * 1000) % 60 + " minutes"]]></textFieldExpression>
</textField>