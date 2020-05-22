List<Throwable> exlist = new ArrayList<>();
while(ex.getCause()!=null) {
    exlist.add(ex.getCause());
    ex = ex.getCause();
}
exlist = exlist.stream().filter(e -> e instanceof MyCustomRunTimeException).collect(Collectors.toList());