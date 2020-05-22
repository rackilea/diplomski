<form th:object="${payment}" th:action="@{/sendPayment}" method="post">
      <input type="text" th:field="*{id}"/>
      <input type="text" th:field="*{service.name}"/>
      <input type="text" th:field="*{user.id}"/>
      <button type="submit">Submit</button>
</form>