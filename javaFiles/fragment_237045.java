<div class="form-group blu-margin">
    <select class="form-control" th:field="${operator.opeId}"  id="dropOperator">
    <option value="0">select operator</option>
    <option th:each="operator : ${operators}" th:value="${operator.id}" th:text="${operator.operatorName}"></option>
    </select>
</div>