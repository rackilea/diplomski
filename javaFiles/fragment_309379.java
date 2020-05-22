{
"info" : {
    "elements" : {
        "element" : [
            {
                "name" : "mysystem",
                "description" : "Please the name of your system (ex. marketing, hr, accounting, etc).",
                "type" : "java.lang.String",
                "page" : 0,
                "required" : true,
                "pattern" : "\\w+",
                "replaceKind" : "token"
            },
            {
                "name" : "myapp",
                "description" : "Please the name of your application (ex. thisapplication, thatapplication, etc).",
                "type" : "java.lang.String",
                "page" : 1,
                "required" : true,
                "pattern" : "\\w+",
                "replaceKind" : "token"
            }
        ]
    },

    "projectName" : "projectName",

    "pages" : {
        "page" : [
                {
                "order" : 0,
                "description" : "System Info"
                }
          ],
          "page" : [
                {
                "order" : 1,
                "description" : "System Info 2"
                }
          ]
    }
}