for(int i=0; i<names.length; i++){         
    workers[i] = new Worker(names[i], surnames[i], ages[i]);
}
if (names.length < n) {
    for(int i = names.length; i<n; i++){
        workers[i] = new Worker();
    }
}