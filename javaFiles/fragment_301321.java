<form th:action="@{/search}" method="GET" th:object="${searchForm}" onsubmit="interceptFilterForm(this);">
  <input type="hidden" name="q" th:value="${searchForm.q}" />
  <input type="submit" value="Filter" ></input>

  <li th:each="facet : ${results.facets}" >
    <input type="checkbox" name="filters" th:value="${facet.fullPath}" th:field="*{filters}" />
  </li>  
</form>