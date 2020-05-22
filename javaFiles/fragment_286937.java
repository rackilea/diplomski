<form>
    <div th:each="parameter,iterStat : ${persons}" class="personsContainer">
        <input type="text" th:value="${parameter.name}" th:name="'people[' + ${iterStat.index} + '].name'">
        <input type="text" th:value="${parameter.age}" th:name="'age[' + ${iterStat.index} + '].age'">
    </div>
</form>