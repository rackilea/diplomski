db.getCollection('yourCollectionName').aggregate([{
        $match: {
            "bot_id": "1",
            "page_id": "2039339889632748"
        }
    },
    {
        $group: {
            _id: {
                first_name: "$meta_data.user_data.first_name",
                last_name: "$meta_data.user_data.last_name",
                profile_pic: "$meta_data.user_data.profile_pic",
                user_id: "$user_id",
                last_message: "$live_agent.last_message",
                last_access_time: "$meta_data.user_data.last_access_time"
            }
        }

    },

    {
        $sort: {
            "_id.last_access_time": -1
        }
    }
])