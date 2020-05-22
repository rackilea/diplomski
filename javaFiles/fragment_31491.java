val input = "1035+56-7894*9985.3"

val numberRegex = Regex("[\\d,.]+") // this actually filters out consecutives digits, commas and dots 

val result = numberRegex.replace(input) { 
    val num = BigDecimal(it.value)
    "%,.2f".format(Locale.US, num)
}

println(result)