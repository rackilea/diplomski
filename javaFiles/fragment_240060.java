<% 
    User user = (User)session.getAttribute("newUser");
    //          ^^^^^^ - this means that you claim that you are sure that returned 
    //                   Object is in fact of type User (such casting is possible 
    //                   because compiler knows that like everything in Java - except
    //                   primitive types - User extends Object).
%>