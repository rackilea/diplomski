db.collection.update(
    { 
        "screens.caseCodes.key": "CS_CAT1"
    },
    {
        "$set": { 
            "screens.caseCodes.$.parameterizedValue": "new value"
        }
    }
)