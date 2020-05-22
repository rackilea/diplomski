db.collection.update(
    { 
        "screens._id": "caseCodes",
        "screens.dictionary.key": "MY_INVESTIGATIONS"
    },
    {
        "$set": { 
            "screens.0.dictionary.1.parameterizedValue": "new value"
        }
    }
)