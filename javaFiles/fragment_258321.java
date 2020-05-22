<tr th:each="replacedPart, stat : *{replacedPartList}">
    <td th:text="${__${stat.index}__}"></td>
    <td><input type="text" th:value="*{replacedPartList[__${stat.index}__].partSerialNo}" th:field="*{replacedPartList[__${stat.index}__].partSerialNo}"></td>
    <td><input type="text" th:value="*{replacedPartList[__${stat.index}__].quantity}" th:field="*{replacedPartList[__${stat.index}__].quantity}"></td>
    <td><input type="text" th:value="*{replacedPartList[__${stat.index}__].unitPrice}" th:field="*{replacedPartList[__${stat.index}__].unitPrice}"></td>
    <td><input type="text" th:value="*{replacedPartList[__${stat.index}__].totalPrice}" th:field="*{replacedPartList[__${stat.index}__].totalPrice}"></td>
</tr>