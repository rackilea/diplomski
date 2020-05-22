<ol>
    <li th:each="bean: ${staticBeans}">
        <div th:text="${bean.className}" /></div>

        <ul th:each="property: ${bean.properties}">
            <li th:text="${property.val}" />
        </ul>
    </li>
</ol>