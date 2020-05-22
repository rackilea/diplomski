fun ini_conection(onResult: ArrayList<arrayitem> -> Unit) {
    Observable.zip(obs, result2, BiFunction { 
        t1: JSONResponse, 
        t2: List<get> -> Pair(t1, t2) 
    }).subscribe({
        for (i in 0..5) {
            x.add(arrayitem(gson.toJson(it.second.get(i).type)))
            x.add(arrayitem(gson.toJson(it.first.android?.get(i)?.title)))
        } 

        for (s in x) {
            println(s)
        }
        onResult(x)
    })