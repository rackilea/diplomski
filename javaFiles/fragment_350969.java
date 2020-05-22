class Optional<T>(val value: T?) {
  companion object {
    fun <T> empty() = Optional<T>()
    fun <T> from(value: T?) = Optional(value)
  }
}