@XmlRootElement
data class WxPayOrder (
        // all the properties
) {
  // the no-arg-constructor is a must:
  constructor() : this("", body = "", /* all the other properties that must have a value, setting them to a default one */)
}