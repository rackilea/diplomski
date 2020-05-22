<tr th:each="menu : ${menuList}">
    <td th:text="${menu.name}"></td>
    <td><a th:href="@{/foodDescription}" th:text="Description">Description</a></td>
    <td th:each="ing : ${menu.ingredient}"> <!-- I have only modified here -->
        <ul>
            <li th:text = ${ing.ingredientName}></li>
        </ul>
    </td>