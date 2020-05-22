<form class="form-horizontal col-sm-12" method="POST" th:action="@{/user/new-user-registrn}" th:object="${registration}">

<div class="row">

    <div class="form-group col-md-12">
        <div class="star-reg-header">New User Registration</div>
    </div>

    <div class="star-reg-body">

        <div class="form-group col-sm-4">
            <label class="required">First Name: </label>
            <input type="text" class="form-control required" th:field="*{firstName}" required="required" />
        </div>

        <div class="form-group col-sm-4">
            <label class="required">Last Name: </label>
            <input type="text" class="form-control" th:field="*{lastName}" required="required" />
        </div>

        <div class="form-group col-sm-4">
            <label class="required">User Name: </label>
            <input type="text" class="form-control" th:field="*{userName}" required="required" />
        </div>

        <div class="form-group col-sm-4">
            <label class="required">Password: </label>
            <input type="password" class="form-control" th:field="*{password}" required="required" />
        </div>

        <div class="form-group col-sm-4">
            <label class="required">Email: </label>
            <input type="text" class="form-control" th:field="*{email}" required="required" />
        </div>

    </div>

</div>
<div class="form-group col-md-12">
    <label class="col-sm-2"></label>
    <div class="col-sm-10">
        <button type="submit" class="btn btn-info">Submit</button>
    </div>
</div>