func split(s, sep string) (tokens []string) {
    fields := strings.FieldsFunc(s, func(r rune) bool {
        return strings.IndexRune(sep, r) != -1
    })
    for _, s2 := range fields {
        s2 = strings.TrimSpace(s2)
        if s2 != "" {
            tokens = append(tokens, s2)
        }
    }
    return
}