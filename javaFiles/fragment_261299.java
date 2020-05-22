flatMap(new Func1<Chapters, Observable<Page>>() {
                @Override
                public Observable<Chapter> call(Chapters chapterList) {
                    return chapterList == null
                        ? Observable.empty()
                        : Observable.from(chapterList);
                }
            })