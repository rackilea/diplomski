\s => [\u0009-\u000D\u0020\u0085\u00A0\u1680\u180E\u2000-\u200A\u2028\u2029\u202F\u205F\u3000]
\S => [^\u0009-\u000D\u0020\u0085\u00A0\u1680\u180E\u2000-\u200A\u2028\u2029\u202F\u205F\u3000]

\v => [\u000A-\u000D\u0085\u2028\u2029]
\V => [^\u000A-\u000D\u0085\u2028\u2029]

\h => [\u0009\u0020\u00A0\u1680\u180E\u2000-\u200A\u202F\u205F\u3000]
\H => [^\u0009\u0020\u00A0\u1680\u180E\u2000\u2001-\u200A\u202F\u205F\u3000]

\w => [\pL\pM\p{Nd}\p{Nl}\p{Pc}[\p{InEnclosedAlphanumerics}&&\p{So}]]
\W => [^\pL\pM\p{Nd}\p{Nl}\p{Pc}[\p{InEnclosedAlphanumerics}&&\p{So}]]

\b => (?:(?<=[\pL\pM\p{Nd}\p{Nl}\p{Pc}[\p{InEnclosedAlphanumerics}&&\p{So}]])(?![\pL\pM\p{Nd}\p{Nl}\p{Pc}[\p{InEnclosedAlphanumerics}&&\p{So}]])|(?<![\pL\pM\p{Nd}\p{Nl}\p{Pc}[\p{InEnclosedAlphanumerics}&&\p{So}]])(?=[\pL\pM\p{Nd}\p{Nl}\p{Pc}[\p{InEnclosedAlphanumerics}&&\p{So}]]))
\B => (?:(?<=[\pL\pM\p{Nd}\p{Nl}\p{Pc}[\p{InEnclosedAlphanumerics}&&\p{So}]])(?=[\pL\pM\p{Nd}\p{Nl}\p{Pc}[\p{InEnclosedAlphanumerics}&&\p{So}]])|(?<![\pL\pM\p{Nd}\p{Nl}\p{Pc}[\p{InEnclosedAlphanumerics}&&\p{So}]])(?![\pL\pM\p{Nd}\p{Nl}\p{Pc}[\p{InEnclosedAlphanumerics}&&\p{So}]]))

\d => \p{Nd}
\D => \P{Nd}

\R => (?:(?>\u000D\u000A)|[\u000A\u000B\u000C\u000D\u0085\u2028\u2029])

\X => (?>\PM\pM*)