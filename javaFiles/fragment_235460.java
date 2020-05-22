db.collection.update({
    "entityId": "12"
}, {
    $push: {
    "nameIdentity": {
        "fName": "123",
        "lName": "456",
        "dob": "00",
        "address": "789"
    }
    }
})