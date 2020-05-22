{
"Name": "Deploy",
"Actions": [
  {
    "Name": "Beta",
    "ActionTypeId": {
      "Category": "Deploy",
      "Owner": "AWS",
      "Provider": "CloudFormation",
      "Version": 1
    },
    "Configuration": {
      "ActionMode": "CREATE_UPDATE",
      "Capabilities": "CAPABILITY_IAM",
      "RoleArn": "CloudformationRole.Arn",
      "StackName": "Harvest",
      "TemplatePath": "BuildOutput::sam-template.yml",
      "ParameterOverrides": "{\"appid\": \"${app123456}\", \"url\": \"https://apple.com\"}"
    },
    "InputArtifacts": [
      {
        "Name": "BuildOutput"
      }
    ],
    "RunOrder": 1
  }
]
}