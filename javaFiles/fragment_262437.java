requestBody: """
            {
                "title": "${title}",
                "description": "${description}",
                "state": "OPEN",
                "open": true,
                "closed": false,
                "fromRef": { "id": "${sourceBranch}" },
                "toRef": { "id": "${targetBranch}" },
                "locked": false,
                "reviewers": ${JsonOutput.toJson(names.collect{ [user: [name: it]] })}
            }
        """