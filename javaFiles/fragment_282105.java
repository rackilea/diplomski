(\d)   Match a digit and capture it (capture group #1)
\1{2}  Match 2 more of the captured digit
\D?    Optionally match a non-digit
\1{3}  Match 3 more of the captured digit
\D?    Optionally match a non-digit
\1{4}  Match 4 more of the captured digit