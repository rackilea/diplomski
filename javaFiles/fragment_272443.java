{

    "eventNotification": {
        "url": "[Callback Url]",
        "loggingEnabled": "true",
        "requireAcknowledgment": "true",
        "envelopeEvents": [
            { "envelopeEventStatusCode": "Delivered" },
            { "envelopeEventStatusCode": "Completed" },
            { "envelopeEventStatusCode": "Declined" },
            { "envelopeEventStatusCode": "Voided" },
            { "envelopeEventStatusCode": "Sent" }
        ],
        "recipientEvents": [
            { "recipientEventStatusCode": "Sent" },
            { "recipientEventStatusCode": "Delivered" },
            { "recipientEventStatusCode": "Completed" },
            { "recipientEventStatusCode": "Declined" },
            { "recipientEventStatusCode": "AuthenticationFailed" },
            { "recipientEventStatusCode": "AutoResponded" }
        ],
    },

    "recipients": {
        "signers": [
            {
                "name": "john smith",
                "email": "johnsmith@foo.com",
                "recipientId": "1",
                "routingOrder": "1"
            }
        ]
    },
    "documents": [
        {
            "documentId": "1",
            "name": "Agreement ",
            "fileExtension": "pdf",
            "documentBase64": "[Document Bytes]"
        }
    ],
    "status": "sent",
    "emailSubject": "Envelope for auto responded status"
}