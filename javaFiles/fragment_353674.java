@GetMapping("/user")
fun find(@RequestParam data: Map<String, Any>): Map<String, Any> {
    val id = data.get<String>("id") // string
    println(id)
    return data
}