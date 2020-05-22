db.taxistationOfCollection.aggregate([
                         {$group: 
                             { _id:
                                    {station: "$TaxiStation", 
                                    licence: "$TaxiLicense"},
                              count : {$sum : 1}
                          }
                        ])