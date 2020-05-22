{
    "name": "http.server.requests",
    "description": null,
    "baseUnit": "seconds",
    "measurements": [
        {
            "statistic": "COUNT",
            "value": 13
        },
        {
            "statistic": "TOTAL_TIME",
            "value": 0.42338
        },
        {
            "statistic": "MAX",
            "value": 0
        }
    ],
    "availableTags": [
        {
            "tag": "exception",
            "values": [
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
                "/actuator/metrics/{requiredMetricName}",
                "/getCountByStatus"
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
                "404",
                "200"
            ]
        }
    ]
}