db.ledger.aggregate([
    {
        "$unwind": "$Accounts"
    },
    {
        "$project": {
            "Total_Credits" : "$Accounts.Total_Credits",
            "Total_Debits" : "$Accounts.Total_Debits",
            "month_year" : {  "$substr": [ "$Accounts.Date", 3, -1 ] }
        }
    },
    {
        "$group": {
            "_id": "$month_year",
            "Total_Credits": { "$sum": "$Total_Credits" },
            "Total_Debits": { "$sum": "$Total_Debits" }
        }
    }
])