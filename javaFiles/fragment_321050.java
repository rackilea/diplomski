query OptionalButRecommendedQueryName ($var1: String) {
  getItem(dictionaryType: $var1) {
    code
    name
    description
  }
}