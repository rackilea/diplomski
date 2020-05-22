Map<String, String> users = new HashMap<Integer, String>();
users.put("C", "Consultant");
users.put("G", "AdminUser");
users.put("L", "LogInUser");
users.put("S", "Staff");

<form:select path="mapUser" class="form-control">
    <form:option value="NONE" label="--Please Select One--" />
    <form:options items="${mapUser}"/>
</form:select>