<textFieldExpression class="java.util.Date">
    <![CDATA[$P{SIMPLE_DATE_FORMAT_WITH_TIME_ZONE}.parse($P{SIMPLE_DATE_FORMAT_WITH_TIME_ZONE}.format($F{inspectionQCCompleteDate}))]]>
</textFieldExpression>


<textFieldExpression class="java.util.Date">
    <![CDATA[$P{SIMPLE_DATE_FORMAT_WITH_TIME_ZONE}.parse($P{SIMPLE_DATE_FORMAT_WITH_TIME_ZONE}.format($F{inspectionCompleteDate}))]]>
</textFieldExpression>