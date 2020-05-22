private fun removeSpaces(s: CharSequence) {
    // e.g. s is " 2 + 3 - { some value } " 
    s = s.trim()
    // now s is "2 + 3 - { some value }"

    // define a regex matching a pattern of characters including some spaces before and after an operator (+,-,*,/)
    val re = Regex("""\s*([\+\-\*\/])\s*""")

    // $1 denotes the group in the regex containing only an operator
    val textWithoutSpaces = re.replace(s, "$1")
    // textWithoutSpaces is "2+3-{ some value }"

    getText().clear()
    append(textWithoutSpaces)
    setSelection(textWithoutSpaces.length)
}