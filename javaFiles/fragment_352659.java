// Get all users
var users = UserDetail.query(); // Calls: GET /ClearsoftDemoBackend/webresources/clearsoft.demo.users

// Get user with iD 1
var user = UserDetail.get({},{'id': 1}); // Calls: GET /ClearsoftDemoBackend/webresources/clearsoft.demo.users/1

// Find user with iD 1
var user = UserDetail.find({},{'id': 1}); // Calls: GET /ClearsoftDemoBackend/webresources/clearsoft.demo.users/1