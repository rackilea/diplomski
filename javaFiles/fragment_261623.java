$ cat foo
123
1{3}
\d{3}
\d\d\d

$ grep '\d{3}' foo
\d{3}

$ grep '\\d\\d\\d' foo
\d\d\d

$ grep '\d\d\d' foo
ddd