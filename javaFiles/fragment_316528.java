tab.sort { a, b ->
    [ a, b ]*.tokenize( '.' )
             .transpose()
             .findResult { x, y ->
                  x.toInteger() <=> y.toInteger() ?: null
              }
}