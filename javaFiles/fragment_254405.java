$project: {
         bookCategory: {
            $filter: {
               input: "$bookCategory",
               as: "bookCat",
               cond: { $eq: [ "$$bookCat.categoryCode", "Cooking/"] }
            }
         }
      }