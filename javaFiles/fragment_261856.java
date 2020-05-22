<#assign count = 0>

<#list recordList as record>
    <#if record.isNotExcluded()>            
        <#lt> Record ${count}   
        <#assign count = count + 1>
    </#if> 
</#list>