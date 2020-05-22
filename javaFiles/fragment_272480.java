<th:block th:each="comment: ${comments}">
    <div th:replace="template :: comments(${comment})" />
</th:block>

<th:block th:if="${false}">
    <ul th:fragment="comments(comment)">
        <li>
            <div th:text="${comment.text}" />

            <th:block th:unless="${#lists.isEmpty(comment.children)}" th:each="child: ${comment.children}">
                <div th:replace="template :: comments(${child})" />
            </th:block>
        </li>
    </ul>
</th:block>