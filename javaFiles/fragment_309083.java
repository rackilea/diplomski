<th:block th:each="comment : ${comments}">
  <p th:text="${comment.content}">comment</p>
  <div th:fragment="f_call(comment)" 
      th:unless="${#lists.isEmpty(comment.children)}" >
      <div th:each="child : ${comment.children}" th:inline="text">
          [[${child.content}]]
          <div th:replace="this::f_call(${child})"></div>
      </div>
  </div>
</th:block>