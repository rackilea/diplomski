<#macro docAsComment doc indent=1>
   <#local spc>${""?left_pad(indent * 4)}</#local>
${spc}/*
<#if doc.title != "">
${spc}* ${doc.title}
</#if>
<#list doc.content as content>
<#if content != "">${spc} * ${content}</#if>
</#list>
${spc}*/
</#macro>