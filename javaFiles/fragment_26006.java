"get": {
        "prefix": "get",
        "body": [
            "public ${1:Type} get${2:Property} () {",
            "\treturn ${2/([A-Z])/${1:/downcase}/};",
            "}"
        ],
        "description": "Creates a get method"
    }