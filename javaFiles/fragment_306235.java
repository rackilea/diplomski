<table>
<#list accounts as account>
    <tr>
    <#list account?keys as prop>
        <td>${account[prop]}</td>
    </#list>
    </tr>
</#list>  
</table>