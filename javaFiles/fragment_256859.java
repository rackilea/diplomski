<?xml version="1.0"?>
<thlogic>
    <attr sel="#ProductTable" th:remove="all-but-first">
        <attr sel="/tr[0]" th:each="prod : ${products}">
            <attr sel="td.Name" th:text="${prod.name}" />
            <attr sel="td.Price" th:text="${prod.price}" />
            <attr sel="td.InStock" th:text="${prod.inStock}" />
            <attr sel="td.Comments" th:text="${prod.comments != null and (not #lists.isEmpty(prod.comments)) ? #lists.size(prod.comments) : 0}" />
        </attr>
    </attr>
</thlogic>