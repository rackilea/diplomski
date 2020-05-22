<tr>
  <td th:text="${user.id}">1</td>
  <td th:text="${user.username}">Hamdo</td>
  <td>
    <p th:each="tweet : ${tweets}" th:text="${tweet.content}" />
  </td>
</tr>