test:Mongo > db.abhi.insert({ name : 'abhi', attr : [ { attr1 : 'val1' }, { attr2 : 'val2'}, {attr3 : 'val3'} ]})

test:Mongo > db.abhi.ensureIndex({attr : 1})
test:Mongo > db.abhi.find({attr : {attr1 : 'val1'}}).explain()
{
    "cursor" : "BtreeCursor attr_1",
    "isMultiKey" : true,
    "n" : 1,
    "nscannedObjects" : 1,
    "nscanned" : 1,
    "nscannedObjectsAllPlans" : 1,
    "nscannedAllPlans" : 1,
    "scanAndOrder" : false,
    "indexOnly" : false,
    "nYields" : 0,
    "nChunkSkips" : 0,
    "millis" : 0,
    "indexBounds" : {
        "attr" : [
            [
                {
                    "attr1" : "val1"
                },
                {
                    "attr1" : "val1"
                }
            ]
        ]
    },
    "server" : "bdvlpabhishekk:27017"
}