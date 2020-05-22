<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
    xmlns:th="http://www.thymeleaf.org"
    xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
    layout:decorate="~{default}">
<head>
<title>Books</title>
</head>
<body>
    <table>
        <tr th:each="book: ${books}">
            <h1>
                <td th:text="${book.author}"></td>
            </h1>
            <td th:text="${book.name}"></td>
        </tr>
    </table>
</body>
</html>