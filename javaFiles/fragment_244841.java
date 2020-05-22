{
    "name": "http.server.requests",
    "description": null,
    "baseUnit": "seconds",
    "measurements": [
        {
            "statistic": "COUNT",
            "value": 3
        },
        {
            "statistic": "TOTAL_TIME",
            "value": 0.21817219999999998
        },
        {
            "statistic": "MAX",
            "value": 0.1379249
        }
    ],
    "availableTags": [
        {
            "tag": "exception",
            "values": [
                "MethodArgumentTypeMismatchException",
                "None"
            ]
        },
        {
            "tag": "method",
            "values": [
                "GET"
            ]
        },
        {
            "tag": "uri",
            "values": [
                "/{id}.*",
                "/user/asset/getAsset/{assetId}",
                "/user/asset/getAllAssets"
            ]
        },
        {
            "tag": "outcome",
            "values": [
                "CLIENT_ERROR",
                "SUCCESS"
            ]
        },
        {
            "tag": "status",
            "values": [
                "400",
                "404",
                "200"
            ]
        }
    ]
}