$http({
url : REST_END_POINT + '/checkuser',
method : "GET",
params : {
    'userId' : credentials.username,
    'pwd' : credentials.password
},
dataType : "json",
headers : {
    "Content-Type" : "application/json"
}
});