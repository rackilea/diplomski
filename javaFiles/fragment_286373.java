<sql:update var="updatevariable" dataSource="${data}">
    UPDATE DATA
    SET NAME = '${param.newname}'
    WHERE NAME = '${sessionName}'
</sql:update> 
<sql:update var="updatevariable2" dataSource="${data}">
    UPDATE DATA
    SET NUMBER = '${param.newnumber}'
    WHERE NUMBER = '${sessionNumber}'
</sql:update>