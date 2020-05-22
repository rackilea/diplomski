<ul>
<#list hm2d?keys as hm2d_key>
    <#assign hm = hm2d[hm2d_key]>
    <li>${hm2d_key}:
        <ul>
        <#list hm?keys as key>
            <li>${key} = ${hm[key]}</li>
        </#list>
        </ul>
    </li>
</#list>
</ul>