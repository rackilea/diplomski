List<Library> libs;
// populate the libraries
Map<String,Map<String,Book>> map = libs.
    stream().
    collect(Collectors.toMap(l -> l.name, l -> {
        return l.books.
            stream().
            collect(Collectors.toMap(b -> b.isbn, Function.identity()));  
    }));