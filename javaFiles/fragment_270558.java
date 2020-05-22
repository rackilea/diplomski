class User{

 private String id; //  For e.g. C
 private String value; // For e.g. Consultant
}

List<User> users = new ArrayList<>();
users.add(new User("C", "Consultant"));
users.add(new User("G", "AdminUser"));
users.add(new User("L", "LogInUser"));
users.add(new User("S", "Staff"));

<form:select path="mapUser" class="form-control">
    <form:option value="NONE" label="--Please Select One--" />
    <form:options items="${mapUser}" itemLabel="value" itemValue="id" />
</form:select>