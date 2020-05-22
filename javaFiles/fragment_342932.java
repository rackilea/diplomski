<table>
    <tr th:each="var : ${#vars}">
        <td th:text="${var.key}"></td>
        <td th:text="${var.value}"></td>
    </tr>
</table>