use test
db.createUser({
    user: "loguser2",
    pwd: "logpassword",
    roles: ["readWrite", "dbAdmin"]
})