<div th:switch="${type}" th:remove="all-but-first">
  <th:block th:case="CD">
    <div th:each="track : ${item.trackList}">
      <p th:text="${track}"></p>
    </div>
  </th:block>
</div>