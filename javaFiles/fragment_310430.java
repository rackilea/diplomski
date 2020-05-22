db.testCollection.aggregate([{
            $match : {
                vid : {
                    $in : ["001", "002"]
                },
                ss : "N",
                spt : {
                    $gte : new Date("2016-06-29")
                },
                spf : {
                    $lte : new Date("2016-06-27")
                }
            }
        }, {
            $match : {
                $or : [{
                        sc : {
                            $elemMatch : {
                                $eq : "TEST"
                            }
                        }
                    }, {
                        sc : {
                            $exists : false
                        }
                    }
                ]
            }
        }, {
            $match : {
                $or : [{
                        pt : {
                            $ne : "RATE"
                        }
                    }, {
                        rpis : {
                            $exists : true
                        }
                    }
                ]
            }
        }])