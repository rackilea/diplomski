data class MyData(val foo: String, val bar: String) {
    companion object {
        fun from(map: Map<String, String>) = object : {
            val foo by map
            val bar by map

            val data = MyData(foo, bar)
        }.data
    }