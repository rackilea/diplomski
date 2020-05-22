results.add(getValue(usr,"name"))
results.add(getValue(usr,"about"))

String getValue(def usr, String prop) {
   return usr."${prop}" ?: ""
}