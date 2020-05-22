String key = "my.first.property"
Object value = FOO

// split the key into its components
def keyParts = key.split(/\./)
// do config.my.first (i.e. up to the last-but-one component) and then set
// "property" (the last component) on the resulting ConfigObject
keyParts[0..<(keyParts.size() - 1)].inject(config) {
  conf, k -> conf."${k}"
}."${keyParts[-1]}" = value