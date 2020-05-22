<#-- handy macro for this -->
<#macro enumSelect selectName enumValues>
    <select name="${selectName}">
        <#list enumValues as enum>
        <option value="${enum}">${enum.description}</option>
        </#list>
    </select>
</#macro>

<#-- calling the macro -->
<@enumSelect "myEnumSelectName" myEnum/>