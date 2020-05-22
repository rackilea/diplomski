<form th:action="@{/users}" th:object="${userWrapper}" method="post">
    <!-- other html removed for readability -->
    <tr th:each="u, i : ${listOfUsers}">
        <!-- other rows removed for readability -->
        <td><input type="checkbox" th:field="*{users[__${i.index}__].userChecked}" /></td>
    </tr>
</form>