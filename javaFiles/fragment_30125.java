<table border=1>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.description}</td>
            <td>${product.unitPrice}</td>
            <td>
                <form action="products" method="get">
                    <input type="hidden" name="id" value="${product.id}" />
                    <input type="submit" value="Add to cart"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>