this.readers = new Tuple[context.searcher().subReaders().length];
    for (int i = 0; i < readers.length; i++) {
        IndexReader reader = context.searcher().subReaders()[i];
        readers[i] = new Tuple<IndexReader, IdReaderTypeCache>(reader, context.idCache().reader(reader).type(parentType));
    }
    this.context = context;