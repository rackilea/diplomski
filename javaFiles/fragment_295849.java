@Property
private Map<String, Map<String, Long>> byEventType;

@Property
private Entry<String, Map<String, Long>> entry;

@Property
private Entry<String, Long> entry2;

<tr t:type="Loop" t:source="byEventType.entrySet()" t:value="entry">
<td style="border: 1px solid #EEEEEE; padding: 3px">${entry.key}</td>
<td style="border: 1px solid #EEEEEE; padding: 3px" t:type="Loop" t:source="entry.value.entrySet()" t:value="entry2"> 
    ${entry2.key} = ${entry2.value}
</td>