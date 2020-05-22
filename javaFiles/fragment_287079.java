<html>
    <head>
        <title>${title}</title>
    </head>
    <body>
    Users:<br/><br/>
    <ul>
        <#list users as user>
        <li>${user.lastName} ${user.firstName}</li>
        </#list>
    </ul>
    </body>
</html>