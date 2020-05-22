(              Start capturing group
  (?:          Start non-capturing group
    (?:        Start non-capturing group
      '        Match the literal character '
      [^']     Match a single character that is not '
      *        Greedily match the previous atom zero or more times
      '        Match the literal character '
    )          End non-capturing group
    |          Match either the previous or the next atom
    [^;]       Match a single character that is not ;
  )            End non-capturing group
  *            Greedily match the previous atom zero or more times
)              End capturing group
;              Match the literal character ;