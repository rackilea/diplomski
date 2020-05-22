<select name="combo">
    <#list mylist as it>
        <#list it as tmplattribute>
            <option value="${tmplattribute}">${tmplattribute}</option>
        </#list>
    </#list>
</select>