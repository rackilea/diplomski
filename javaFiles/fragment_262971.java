schema {
        query: Query
    }
    type CustomReport{
    id:Int!,
    name:String!

    }
    type Query {
        reportgroup:ReportGroup
    }

    type ReportGroup{
        name:String!,
         customReport : [CustomReport]
    }