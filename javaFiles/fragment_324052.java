fun String.extractDigits(): String {
    val str = this.trim { it <= ' ' } // Using `this`, i.e. the receiving instance
    var digits = ""
    var chrs: Char
    for (i in 0..str.length - 1) {
        chrs = str[i]
        if (Character.isDigit(chrs)) {
            digits += chrs
        }
    }
    return digits
}