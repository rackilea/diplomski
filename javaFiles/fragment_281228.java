<c:forEach var="item" items="${myCart.cartItems}">
    <tr>
        <td>${item.ID}</td>
        <td>${item.Description}</td>
        <td>${item.Category}</td>
        <td>${item.Price}</td>
        <td>${item.Name}</td>
    </tr>
</c:forEach>