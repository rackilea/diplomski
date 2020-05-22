private val String.numberFromSpelledOut: Boolean
  get() {
    val esFormatter = RuleBasedNumberFormat(Locale.ENGLISH, RuleBasedNumberFormat.SPELLOUT)
    return try {
      return esFormatter.parse(this)
    } catch (e: ParseException) {
      ""
    }
  }