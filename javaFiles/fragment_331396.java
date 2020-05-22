<tbody>
    <c:forEach items="${productManagerForm.products}" var="product" varStatus="status">
        <c:url value="/product/detail/${product.id}" var="detailUrl" />
        <tr>
           <td><a href="${detailUrl}">${product.id}</a> <form:hidden path="products[${status.index}].id" value="${product.id}" /></td>
           <td><form:input path="products[${status.index}].name" class="input-xlarge" type="text"/></td>
           <td><form:input path="products[${status.index}].price" class="input-mini" type="text" /></td>
           <td><form:input path="products[${status.index}].shippingPrice" class="input-mini" type="text" /></td>
           <td><button id="save" name="save" value="${product.id}" class="btn btn-success"><i class="fa fa-save"></i> Save </button>
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#editProduct${product.id}"><i class="fa fa-edit"></i> Edit</button>
                <button id="delete" name="delete" value="${product.id}" class="btn btn-danger"><i class="fa fa-trash-o"></i></button>
           </td>
        </tr>
   </c:forEach>
</tbody>