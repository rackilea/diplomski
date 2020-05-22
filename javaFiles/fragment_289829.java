POST https://myorg.api.crm.dynamics.com/api/data/v9.0/InsertOptionValue HTTP/1.1
Content-Type: application/json; charset=utf-8
OData-MaxVersion: 4.0
OData-Version: 4.0
Accept: application/json

{
    "AttributeLogicalName": "new_localoptionsettoform",
    "EntityLogicalName": "cr965_testcdsentity",
    "Value": "100000002",
    "Label": {
        "LocalizedLabels": [
            {
                "Label": "nerd",
                "LanguageCode": 1033,
                "IsManaged": false,
                "MetadataId": "881daca2-5c68-e911-a825-000d3a1d501d",
                "HasChanged": null
            }
        ],
        "UserLocalizedLabel": {
            "Label": "nerd",
            "LanguageCode": 1033,
            "IsManaged": false,
            "MetadataId": "881daca2-5c68-e911-a825-000d3a1d501d",
            "HasChanged": null
        }
    },
    "Description": {
        "LocalizedLabels": [
            {
                "Label": "",
                "LanguageCode": 1033,
                "IsManaged": false,
                "MetadataId": "881daca2-5c68-e911-a825-000d3a1d501d",
                "HasChanged": null
            }
        ],
        "UserLocalizedLabel": {
            "Label": "",
            "LanguageCode": 1033,
            "IsManaged": false,
            "MetadataId": "881daca2-5c68-e911-a825-000d3a1d501d",
            "HasChanged": null
        }
    }
}