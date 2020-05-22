db.Products.aggregate([
    // Match only those documents that have atleast one category satisfying regex `/el/`
    {$match: {categories: /el/}}, 
    // De-normalize the 'categories' array
    {$unwind: "$categories"}, 
    // Get only those array elements matching regex '/el/'
    {$match: {categories: /el/}}, 
    // Group by the array elements to get distinct value
    {$group: {_id: "$categories"}}
])