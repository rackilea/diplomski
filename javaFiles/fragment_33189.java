<%
    // UserList users = new UserList();
    UserDAO inf= new UserDAO();
    List<User> userList = inf.loadFromDatabase(); // See the changes
    Recommender rc = new Recommender(userList); // Change constructor definition in your Recommender
%>