{
    "provider": {
        "name": "providerA"
    },
    "consumer": {
        "name": "consumerA"
    },
    "interactions": [
        {
            "description": "(GET) /foo",
            "request": {
                "method": "GET",
                "path": "/foo"
            },
            "response": {
                "status": 200,
                "headers": {
                    "Content-Type": "application/json; charset=UTF-8"
                },
                "body": {
                    "id": 100,
                    "content": "Hello johny"
                },
                "matchingRules": {
                    "body": {
                        "$.id": {
                            "matchers": [
                                {
                                    "match": "number"
                                }
                            ],
                            "combine": "AND"
                        },
                        "$.content": {
                            "matchers": [
                                {
                                    "match": "type"
                                }
                            ],
                            "combine": "AND"
                        }
                    }
                },
                "generators": {
                    "body": {
                        "$.id": {
                            "type": "RandomInt",
                            "min": 0,
                            "max": 100
                        }
                    }
                }
            }
        }
    ],
    "metadata": {
        "pact-specification": {
            "version": "3.0.0"
        },
        "pact-jvm": {
            "version": "3.5.10"
        }
    }
}