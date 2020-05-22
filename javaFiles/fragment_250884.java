tests["Status code is 200 (that's good!)"] = (responseCode.code === 200);

eval(postman.getGlobalVariable("bigint_fix"));

var jsonData = JSON.parse(responseBody);
var id_list = [];

jsonData.forEach(function(list) {
    var testTitle = "Org: " + list.name + " has id: " + JSON.stringify(list.id);
    id_list.push(list.id);
    tests[testTitle] = !!list.id;
});

postman.setEnvironmentVariable("organizationId",JSON.stringify(id_list.shift()));
postman.setEnvironmentVariable("id_list", JSON.stringify(id_list));
postman.setNextRequest("GetAdmins");