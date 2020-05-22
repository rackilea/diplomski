<form th:object="${book}" th:action="@{/book/}" method="post">
    <input type="hidden" class="form-control" th:field="*{id}"/>
    <label>title</label>
    <input type="text" class="form-control" th:field="*{title}"/>
    <label>isbn</label>
    <input type="text" class="form-control" th:field="*{isbn}"/>
    <label>description</label>
    <input type="text" class="form-control" th:field="*{description}"/>
    <label>cat</label>
    <ul>
        <li th:each="category : ${book.getCategorySet()}" th:text="category.getCategory()"></li>
    </ul>
    <label>author</label>
    <input type="text" class="form-control" name="author"/>
    <input type="submit" value="Submit" />
    <input type="reset" value="Reset" />
</form>