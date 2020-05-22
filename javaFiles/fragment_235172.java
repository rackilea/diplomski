public class ${className} {
    @Test(groups="${testGroups}")
    public void ${testMethodName}() {
        <#list methods as m>
        ${m}
        </#list>   
    }
}