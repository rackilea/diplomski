$http().get('/mav8/rest/users/getUserById?id=1').success(function(response){
    $scope.response = response;
}).error(function(error){
    $scope.error = error;
});


@GET
@Path("getUserById")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public User getUserByIdInJSON(@QueryParam("id") int id) {
    UserService userService = new UserService();
    System.out.println(id);
    return userService.getUserById();
}