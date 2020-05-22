<form action="#" th:action="@{/books}" th:object="${book}" method="post">
...

<select th:field="*{authorId}">
    <option th:each="author : ${authors}"
            th:value="${author.id}"
            th:text="${author.name}"/>
</select>

...