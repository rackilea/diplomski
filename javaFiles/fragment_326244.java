<form action="#" th:action="@{/kpi}" th:object="${kpi}" method="post">
    <select th:field="*{id}">
        <option th:each="entry : ${list}"
                th:value="${entry.key}"
                th:text="${entry.value.name}">
        </option>
    </select>
    <div th:text="kpi.post.username"></div>
    <!-- THIS -->
    <input th:field="*{post.username}" th:value="${kpi.post.username}" />
    <button type="submit">See KPI</button>
</form>