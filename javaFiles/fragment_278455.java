<#macro docAsComment doc indent=1>
    <#local spc>${""?left_pad(indent * 4)}</#local>
    ${spc}/*<#lt>
    <#if doc.title != "">
        ${spc}* ${doc.title}<#lt>
    </#if>
    <#list doc.content as content>
        <#if content != "">${spc} * ${content}</#if><#lt>
    </#list>
    ${spc}*/<#lt>
</#macro>