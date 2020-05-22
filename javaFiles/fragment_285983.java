<tr>
<c:forEach items="${productCollection}" var="product" varStatus="status">
    <c:if test="${status.index % 4 == 0 && !status.first && !status.last}">
        </tr>
        <tr>
    </c:if>

    <td>
        <a href="productDetail.htm"><img width="90" alt="${product.productName}" src="${product.productImage}"/></a>
        <a href="productDetail.htm"><c:out value="${product.productName}" /></a>
    </td>
</c:forEach>
</tr>