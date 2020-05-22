$http.post(UserPass, {username : vm.data.username, password : vm.data.password 
}).then(function (res){
 var serverresponse = res.data;
}).then(function (){
// another http request here and so on
 $http.post({}).then(function (){
//etc...
});

});