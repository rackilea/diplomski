[
  {
    "operation": "shift",
    "spec": {
      "id": {
        "$": "[#1].[#1].fieldName",
        "@": "[#1].[#1].fieldValue",
        "#false": "[#1].[#1].editable",
        "#STRING": "[#1].[#1].dataType"
      },
      "OrderType": {
        "$": "[#2].[#1].fieldName",
        "@": "[#2].[#1].fieldValue",
        "#false": "[#2].[#1].editable",
        "#STRING": "[#2].[#1].dataType"
      },
      "Abc": {
        "*": {
          "Name": "[#3].[&1].fieldName",
          "Value": "[#3].[&1].fieldValue",
          "#false": "[#3].[&1].editable",
          "#STRING": "[#3].[&1].dataType"
        }
      }
    }
 },
  {
    "operation": "shift",
    "spec": {
      "*": {
        "*": "MyFieldList.fieldList.[]"
      }
    }
  },
  {
    "operation": "default",
    "spec": {
      "MyFieldList": {
        "Footer": "My Footer"
      }
    }
  }
]