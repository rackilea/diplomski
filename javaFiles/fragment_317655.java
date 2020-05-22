val strList = listOf("abc", "iis", "kjkk") // desired order
val respList = listOf(Resp("iis"), Resp("kjkk"), Resp("abc")) // unsorted

val result = strList.flatMap { str -> 
    respList.filter { 
        it.first == str
    }
}