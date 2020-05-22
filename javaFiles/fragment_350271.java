S <- "asdjb|ak.fvajfabcdefabcdefabcdefabc"
T <- "abcdef"
want <- "asdjb|ak.fvajf"

sp <- strsplit(T, "")[[1]]
pat <- sapply(seq_along(sp), function(i){
                paste(sp[seq_len(i)], collapse = "")
            })
pat <- paste0("(", paste(pat, collapse = "|"), ")*$")

result <- gsub(pat, "", S)
identical(result, want)
[1] TRUE