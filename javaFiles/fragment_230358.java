<#list 0..row.getLastCellNum()-1 as idx>
    <#assign cell = cell.getCell(idx)>
    <#assign cellValue = cell.getStringCellValue()>
    <#assign cellAddress = cell.getAddress().toString()>
    <#if someCondition>                                         
        <td style='background-color:orange'>${cellValue}</td>
    <#else>
        <td>${cellValue}</td>
    </#if>
</#list>