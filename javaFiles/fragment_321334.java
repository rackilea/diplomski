IndexReader reader = DirectoryReader.open(dir);
        final Fields fields = MultiFields.getFields(reader);
        final Iterator<String> iterator = fields.iterator();

        while(iterator.hasNext()) {
            final String field = iterator.next();
            final Terms terms = MultiFields.getTerms(reader, field);
            final TermsEnum it = terms.iterator(null);
            BytesRef term = it.next();
            while (term != null) {
                System.out.println(term.utf8ToString());
                term = it.next();
            }
        }