db.collection.aggregate(

  // Pipeline
  [
    // Stage 1
    {
      $project: {
        bookName : 1,
        revenue : 1,
        unitsSold : 1,
      bookCategory: {
                  $filter: {
                     input: "$bookCategory",
                     as: "bookCat",
                     cond: { $eq:[ 'Cooking', {$substr:["$$bookCat.categoryCode",0,7]}] }
                  }
               }
      }
    },

    // Stage 2
    {
      $unwind: "$bookCategory"
    },

    // Stage 3
    {
      $group: {
         _id: {
              categoryCode: "$bookCategory.categoryCode",
          },
          books : { $push: "$$ROOT" },
          revenue: { $sum:"$revenue" },
          unitsSold: { $sum:"$unitsSold" }
      }
    }

  ]
);