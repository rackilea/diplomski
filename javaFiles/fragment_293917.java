<c:forEach var="car" items="${carList}">
    <tr>
        <td>${car.brand}</td>
        <td>${car.year}</td>
        <td><input type="checkbox" name="isAvailable_${car.id}]" value="${car.available}" ${car.available == 'true' ? 'checked' : ''} /></td>
    </tr>
</c:forEach>