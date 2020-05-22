<form class="form-horizontal" action="myController/indexSubmit" method="post">
    <select name="selectList" class="form-control" placeholder=".input-medium" height>
        <c:forEach items="${viewModel.getlistitems()}" var="item" varStatus="count"> 
            <option value="${count.index}"  ${not empty selectListId && selectListId == count.index ? 'selected' : ''} >${item }</option>
        </c:forEach>
    </select>   
    <button type="submit" class="btn btn-primary btn-medium">Submit</button>   
</form>