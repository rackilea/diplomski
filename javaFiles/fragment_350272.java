repl <- function(x, prefix){
    sp <- strsplit(prefix, "")[[1]]
    pat <- sapply(seq_along(sp), function(i){
                paste(sp[seq_len(i)], collapse = "")
            })
    pat <- paste0("(", paste(pat, collapse = "|"), ")*$")
    result <- gsub(pat, "", x)
    result
}

where <- rep(S, 10)
pref <- rep(T, 10)

sapply(seq_along(where), function(i) repl(where[[i]], pref[[i]]))