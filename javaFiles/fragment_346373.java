defaults {
  foo: "default Value"
}

item = ${defaults} {
  foo: ${?bar}
}