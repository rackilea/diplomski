eval(postman.getGlobalVariable("bigint_fix"));

var jsonData = JSON.parse(responseBody);

jsonData.forEach(function(admin) {
    var testTitle = "Admin: " + admin.name + " has " + admin.orgAccess;
    tests[testTitle] = !!admin.name;
});

var id_list = JSON.parse(environment.id_list);
if (id_list.length > 0) {
    postman.setEnvironmentVariable("organizationId", JSON.stringify(id_list.shift());
    postman.setEnvironmentVariable("id_list", JSON.stringify(id_list));
    postman.setNextRequest("GetAdmins");
}

else {
    postman.clearEnvrionmentVariable("organizationId");
    postman.clearEnvironmentVariable("id_list");
}