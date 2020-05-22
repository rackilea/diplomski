<#list countries as category>
    <#assign keys = category?keys>
    <#list keys as key>
         ${category.get(key)}
    </#list>
 </#list>