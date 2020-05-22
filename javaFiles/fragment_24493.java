<form:form modelAttribute="ingredientFormModel">
    Dish Name: ${dish.name} <br>
    <c:forEach var="ingredient" items="${dish.ingredients}" varStatus="count">
        Ingredient Name: ${ingredient.name} <br>
        <input type="hidden" name="ingredientFormModel.ingredientQuantityList[${count.index}].name" value="${ingredient.name}" />
        Quantity: <input name="ingredientFormModel.ingredientQuantityList[${count.index}].quantity.quantity" type="text" /> </br>
        Unit: <input name="ingredientFormModel.ingredientQuantityList[${count.index}].quantity.unit" type="text"/> </br>
    </c:forEach>         
</form:form>