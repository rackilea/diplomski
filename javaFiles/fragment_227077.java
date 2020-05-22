@POST
@Path("/{param}")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public Response postMsg(UserData userData) {
   ...
}


public class UserData {

    private String userName;
    private String userAddress;
    ... 
    define getter setter 

}


// UI JSON call 

    var url = "rest/employee";
    var type = "POST";
    var data = {
        userName : $("#txtEmpFirstName").val(),
        userAddress : $("#txtEmpLastName").val(),
    };


    $.ajax({
        type : type,
        url : url,
        data : JSON.stringify(data),
        contentType: "application/json",
        success : function(data) {
             alert(data.Success);
             resetEmployee();
             searchEmployee();
        }, error : function(error){ alert(JSON.stringify(error.responseText));}
    });