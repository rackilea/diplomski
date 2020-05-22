try {
    for (count = 0; count < mCursor.getCount(); count++) {
        emitter.onNext(loadContacts(count));
    }
    emitter.onComplete();
}