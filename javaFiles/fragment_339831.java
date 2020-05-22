db.collection.update(
    { 
        "screens._id": "caseCodes",
        "screens.dictionary.key": "CS_CAT1"
    },
    {
        "$set": { 
            "screens.$.dictionary.$.parameterizedValue": "new value"
        }
    }
)