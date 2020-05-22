Add word: fun
          |||
          ||\--- (length: 3, position 3, character 'n') -> set{"fun"})
          |\---- (length: 3, position 2, character 'u') -> set{"fun"})
          \----- (length: 3, position 1, character 'f') -> set{"fun"})

Add word: run
          |||
          ||\--- (length: 3, position 3, character 'n') -> set{"fun, run"})
          |\---- (length: 3, position 2, character 'u') -> set{"fun, run"})
          \----- (length: 3, position 1, character 'r') -> set{"run"})

Add word: raw
          |||
          ||\--- (length: 3, position 3, character 'w') -> set{"raw"})
          |\---- (length: 3, position 2, character 'a') -> set{"raw"})
          \----- (length: 3, position 1, character 'r') -> set{"run, raw"})

Add word: rar
          |||
          ||\--- (length: 3, position 3, character 'r') -> set{"rar"})
          |\---- (length: 3, position 2, character 'a') -> set{"raw, rar"})
          \----- (length: 3, position 1, character 'r') -> set{"run, raw, rar"})