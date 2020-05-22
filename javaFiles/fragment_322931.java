<s:iterator value="pojoList" status="stat">
    <s:textarea name="pojoList[%{#stat.index}].field1">
    <s:textarea name="pojoList[%{#stat.index}].field2">
    <s:textarea name="pojoList[%{#stat.index}].field3">
    <s:textarea name="pojoList[%{#stat.index}].field4">
</s:iterator>