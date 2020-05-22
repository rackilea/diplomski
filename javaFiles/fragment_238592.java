Class parse(val) {
    def convert = [
        (Integer) : { it.toInteger() },
        (Double)  : { it.toDouble() },
        (Date)    : { Date.parse('YYYY-MM-DD hh:mm:ss.sss', it) },
        (Boolean) : { Boolean.parseBoolean it },
        (String)  : { it }
    ]

    convert.findResult { key, value ->
        try {
            if (value(val)) return key
        } catch (e) {}
    }
}

assert parse('9.1') == Double
assert parse('9') == Integer
assert parse('1985-10-26 01:22:00.000') == Date // great scott!
assert parse('chicken') == String
assert parse('True') == Boolean