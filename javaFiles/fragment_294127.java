# Substitution of a map of query parameters
http://foo.bar.com/some/request{?queryparams*}

# "queryparams" associative array:
hello -> world!,
streetInGerman -> Straße

# result of expansion:
http://foo.bar.com/some/request?hello=world%21&streetInGerman=Stra%C3%9Fe