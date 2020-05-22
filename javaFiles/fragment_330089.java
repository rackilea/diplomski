List data = []
    Map map = [:]
     datas.each{adv ->
                        map = [:] //emptying map 
                        if(adv.data.equalsIgnoreCase("myData)){
                            map["id"] = adv.id
                            map["url"] = adv.url
                        }
                 data << map // inserting map into list
                }

     println data.dump() // printing list of maps