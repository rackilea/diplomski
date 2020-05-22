{
"timestamp": "2018-09-25T07:05:03.420+0000",
"status": "400",
"error": "Bad Request",
"errors": [
    {
        "codes": [
            "Positive.beanValidation.price",
            "Positive.price",
            "Positive.java.lang.Integer",
            "Positive"
        ],
        "arguments": [
            {
                "codes": [
                    "beanValidation.price",
                    "price"
                ],
                "arguments": null,
                "defaultMessage": "price",
                "code": "price"
            }
        ],
        "defaultMessage": "价格必须是正数!",
        "objectName": "beanValidation",
        "field": "price",
        "rejectedValue": "-333",
        "bindingFailure": false,
        "code": "Positive"
    },
    {
        "codes": [
            "Email.beanValidation.email",
            "Email.email",
            "Email.java.lang.String",
            "Email"
        ],
        "arguments": [
            {
                "codes": [
                    "beanValidation.email",
                    "email"
                ],
                "arguments": null,
                "defaultMessage": "email",
                "code": "email"
            },
            [],
            {
                "arguments": null,
                "defaultMessage": ".*",
                "codes": [
                    ".*"
                ]
            }
        ],
        "defaultMessage": "邮件地址无效!",
        "objectName": "beanValidation",
        "field": "email",
        "rejectedValue": "fdsaomc.com",
        "bindingFailure": false,
        "code": "Email"
    },
    {
        "codes": [
            "Min.beanValidation.price",
            "Min.price",
            "Min.java.lang.Integer",
            "Min"
        ],
        "arguments": [
            {
                "codes": [
                    "beanValidation.price",
                    "price"
                ],
                "arguments": null,
                "defaultMessage": "price",
                "code": "price"
            },
            "666"
        ],
        "defaultMessage": "最低价格是666!",
        "objectName": "beanValidation",
        "field": "price",
        "rejectedValue": "-333",
        "bindingFailure": false,
        "code": "Min"
    }
],
"message": "Bad Request",
"path": "/contextPath/bv2"