csr = db.query(
            sq_child_mismatches, //<<<<<<<<<< the fake subquery
            new String[]{
                    sq_child_mismatches,
                    sq_friend_mismatches
            },
            null    ,null,null,null,null
    );