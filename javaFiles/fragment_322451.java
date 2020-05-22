testReplSet:PRIMARY> db.Lead.insert({LeadID: 1, MasterAccountID: 100, LeadName: 'Sarah', LeadEmailID : 'sarah@hmail.com', LeadPhoneNumber : '2132155445', Details : { StateID: 1, TaskID : 1, "Assigned By" : 1001, TimeStamp : '10:00:00', StatusID : 1 }})
testReplSet:PRIMARY> db.Lead.findOne()
{
    "_id" : ObjectId("517fac61a010d6dfc17bd6ae"),
    "LeadID" : 1,
    "MasterAccountID" : 100,
    "LeadName" : "Sarah",
    "LeadEmailID" : "sarah@hmail.com",
    "LeadPhoneNumber" : "2132155445",
    "Details" : {
        "StateID" : 1,
        "TaskID" : 1,
        "Assigned By" : 1001,
        "TimeStamp" : "10:00:00",
        "StatusID" : 1
    }
}