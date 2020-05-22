<c:choose>
    <c:when test="#{product.category.parent.uri == null}">
        <f:param name="cat" value="#{product.category.uri}" rendered="" />
    </c:when>
    <c:otherwise>
        <f:param name="cat" value="#{product.category.parent.uri}" />
    </c:otherwise>
</c:choose>