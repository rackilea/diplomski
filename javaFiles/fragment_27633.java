<table >
    <tr th:each="todoList: ${todoLists}">
    <td th:text="${todoList.name}"></td>
    <td th:text="${todoList.priority}"></td>
    <td th:text="${todoList.status}"></td>
    </tr>
</table>