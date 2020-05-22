Observable.fromIterable(books)
    .map(new Function<Book, Map<String, Object>>() {
        @Override
        public Map<String, Object> apply(Book book) throws Exception {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", book.id);
            map.put("quantity", book.quantity);
            return map;
        }
    })
    .toList()
    .subscribe(new Consumer<List<Map<String, Object>>>() {
        @Override
        public void accept(List<Map<String, Object>> mapsList) throws Exception {
            System.out.println(mapsList);
        }
    });