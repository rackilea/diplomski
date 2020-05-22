{
    "$schema": "http://json-schema.org/draft-04/schema#",
    "id": "",
    "type": "object",
    "title": "Add Temp Configlet Builder Schema",
    "description": "Schema structure for adding temp configlet builder",
    "properties": {
        "formList": {
            "id": "formList",
            "type": "array",
            "title": "Form List values",
            "description": "The list of form entries",
            "items": {
                "type": "object",
                "properties": {
                    "type": {
                        "id": "type",
                        "type": "string",
                        "title": "The Type",
                        "description": "The type of form element"
                    },
                    "fieldId": {
                        "id": "fieldId",
                        "type": "string",
                        "title": "The Field Id",
                        "description": "The Id of the form field"
                    },
                    "fieldLabel": {
                        "id": "fieldLabel",
                        "type": "string",
                        "title": "The Field Label",
                        "description": "The label value of form field"
                    },
                    "value": {
                        "id": "value",
                        "type": "string",
                        "title": "The value",
                        "description": "The value of the form field"
                    },
                    "depends": {
                        "id": "depends",
                        "type": "string",
                        "title": "Depends on",
                        "description": "To indicate if the field depends on another field"
                    },
                    "validation": {
                        "id": "validation",
                        "type": "object",
                        "title": "Validation field",
                        "description": "To indicate if the field has any validation",
                        "properties": {
                            "mandatory": {
                                "id": "mandatory",
                                "type": "boolean"
                            }
                        }
                    },
                    "dataValidation": {
                        "id": "dataValidation",
                        "type": "string",
                        "title": "Data Validation field",
                        "description": "Contains the data validation condition"
                    },
                    "helpText": {
                        "id": "helpText",
                        "type": "string",
                        "title": "Help text",
                        "description": "Contains the help text for the field"
                    },
                    "key": {
                        "id": "key",
                        "type": "string"
                    }
                },
                "required": [
                    "type",
                    "fieldId",
                    "fieldLabel",
                    "value",
                    "depends",
                    "validation",
                    "dataValidation",
                    "helpText",
                    "key"
                ]
            }
        },
        "action": {
            "id": "action",
            "type": "string",
            "title": "Action type",
            "description": "Type of action to be performed",
            "enum": [
                "update",
                "add",
                "delete"
            ]
        },
        "mainScript": {
            "id": "mainScript",
            "type": [
                "object",
                "string"
            ],
            "properties": {
                "data": {
                    "id": "data",
                    "type": "string",
                    "title": "The mainscript data",
                    "description": "Contains mainscript data"
                },
                "key": {
                    "id": "mainscript_key",
                    "type": "string"
                }
            },
            "oneOf":[  
                {  

                },
                {  
                    "not":{  
                        "required":[  
                            "data",
                            "key"
                        ]
                    }
                }
            ]
        }
    },
    "required": [
        "formList",
        "action",
        "mainScript"
    ],
    "additionalProperties": false
}