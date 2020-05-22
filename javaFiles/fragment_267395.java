db.post.aggregate([
  {
    $match: {}
  },
  {
    $lookup: {
      from: "users",
      let: {
        postedBy: "$postedBy"
      },
      pipeline: [
        {
          $match: {
            $expr: {
              $eq: [
                {
                  "$toString": "$_id"
                },
                "$$postedBy"
              ]
            }
          }
        }
      ],
      as: "user"
    }
  },
  {
    $unwind: "$user"
  },
  {
    $addFields: {
      id: {
        $toString: "$_id"
      },
      username: "$user.name",
      upvotes: {
        $size: "$upvotesBy"
      },
      isUpvoted: {
        $in: [
          "5e18b4c12753608718dfa007",
          "$upvotesBy"
        ]
      },
      isPinned: {
        $cond: [
          {
            $gte: [
              {
                $size: "$upvotesBy"
              },
              3
            ]
          },
          true,
          false
        ]
      },
      createdAt: {
        $dateToString: {
          format: "%H:%M %d-%m-%Y",
          timezone: "+01",
          date: "$createdAt"
        }
      }
    }
  },
  {
    $sort: {
      "isPinned": -1,
      "createdAt": -1
    }
  },
  {
    $project: {
      _id: 0,
      user: 0,
      upvotesBy: 0,
      _class: 0
    }
  }
])