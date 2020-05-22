//...
sources.map(v -> {
    UnicastSubject<Long> subject = UnicastSubject.create();
    v.subscribe(subject);
    return subject;
})
//...