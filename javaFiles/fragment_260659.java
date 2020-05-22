<li class="page-item">
    <a class="page-link" th:if="${page.hasPrevious()}" th:href="@{/(page=${page.previousPageable().getPageNumber()},size=${page.getSize()})}">&larr; Older</a>
</li>
<li class="page-item disabled">
    <a class="page-link" th:if="${page.hasNext()}" th:href="@{/(page=${page.nextPageable().getPageNumber()},size=${page.getSize()})}">Newer &rarr;</a>
</li>