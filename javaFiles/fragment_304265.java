{
    "title": "cat7-SQL Injection",
    "description": "alert description",
    "type": "Internal ",
    "source": "Splunk ",
    "sourceRef": "Splunk alert ",
    "severity": 2,
    "tlp": 2,
    "artifacts": [{
            "dataType": "ip",
            "data": "<template_ip>",
            "message": "<template_message>",
            "tags": ["SQL Injection"]
        },
        {
            "dataType": "user - agent",
            "data": "<template_user_agent>",
            "tags": ["SQL Injection"]
        }
    ],
    "caseTemplate": "SQL Injection"
}