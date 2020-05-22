<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%><%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><!DOCTYPE HTML>
<html>
<head>

    <title>Edit</title>
    <style type="text/css">.hidden {display: none;}</style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    <script type="text/javascript">
    $(function() {

        // Start indexing at the size of the current list
        var index = ${fn:length(employer.employees)};

        // Add a new Employee
        $("#add").off("click").on("click", function() {
            $(this).before(function() {
                var html = '<div id="employees' + index + '.wrapper" class="hidden">';                    
                html += '<input type="text" id="employees' + index + '.firstname" name="employees[' + index + '].firstname" />';
                html += '<input type="text" id="employees' + index + '.lastname" name="employees[' + index + '].lastname" />';
                html += '<input type="hidden" id="employees' + index + '.remove" name="employees[' + index + '].remove" value="0" />';
                html += '<a href="#" class="employees.remove" data-index="' + index + '">remove</a>';                    
                html += "</div>";
                return html;
            });
            $("#employees" + index + "\\.wrapper").show();
            index++;
            return false;
        });

        // Remove an Employee
        $("a.employees\\.remove").off("click").on("click", function() {
            var index2remove = $(this).data("index");
            $("#employees" + index2remove + "\\.wrapper").hide();
            $("#employees" + index2remove + "\\.remove").val("1");
            return false;
        });

    });
    </script>

</head>
<body>

    <c:choose>
        <c:when test="${type eq 'create'}"><c:set var="actionUrl" value="employer/create" /></c:when>
        <c:otherwise><c:set var="actionUrl" value="employer/update/${employer.id}" /></c:otherwise>
    </c:choose>

    <form:form action="${actionUrl}" modelAttribute="employer" method="POST" name="employer">
        <form:hidden path="id" />
        <table>
            <tr>
                <td><form:label path="firstname">Firstname</form:label></td>
                <td><form:input path="firstname" /><form:errors path="firstname" /></td>
            </tr>
            <tr>
                <td><form:label path="lastname">Lastname</form:label></td>
                <td><form:input path="lastname" /><form:errors path="lastname" /></td>
            </tr>
            <tr>
                <td><form:label path="company">company</form:label></td>
                <td><form:input path="company" /><form:errors path="company" /></td>
            </tr>
            <tr>
                <td>Employees</td>
                <td>
                    <c:forEach items="${employer.employees}" varStatus="loop">
                        <!-- Add a wrapping div -->
                        <c:choose>
                            <c:when test="${employer.employees[loop.index].remove eq 1}">
                                <div id="employees${loop.index}.wrapper" class="hidden">
                            </c:when>
                            <c:otherwise>
                                <div id="employees${loop.index}.wrapper">
                            </c:otherwise>
                        </c:choose>
                            <!-- Generate the fields -->
                            <form:input path="employees[${loop.index}].firstname" />
                            <form:input path="employees[${loop.index}].lastname" />
                            <!-- Add the remove flag -->
                            <c:choose>
                                <c:when test="${employees[loop.index].remove eq 1}"><c:set var="hiddenValue" value="1" /></c:when>
                                <c:otherwise><c:set var="hiddenValue" value="0" /></c:otherwise>
                            </c:choose>
                            <form:hidden path="employees[${loop.index}].remove" value="${hiddenValue}" />
                            <!-- Add a link to remove the Employee -->
                            <a href="#" class="employees.remove" data-index="${loop.index}">remove</a>
                        </div>
                    </c:forEach>
                    <button id="add" type="button">add</button>
                </td>
            </tr>
        </table>
        <button type="submit">OK</button>
    </form:form>

</body>
</html>