...
for(int i=1; i<=20; i++) {
    results.add(exec.submit(new MyCallable(i))); 
}
try {
    for(Future<Integer> result: results) {
            System.out.write(result.get(), 0, result.get().length);
    }
}
...