use admin
db.createUser({
    user: "loguser3",
    pwd: "logpassword",
    roles: ["readWriteAnyDatabase", "dbAdmin"]
})