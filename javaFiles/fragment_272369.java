<ul>
    <li th:each="role : ${rolesList}">
        <label th:for="${role.name}" th:text="${role.name}">Role name</label>
        <input type="checkbox" th:id="${role.name}"
               th:name="${role.name}" th:checked="${role.active}"/>
    </li>
</ul>