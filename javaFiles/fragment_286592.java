override fun downloadPhoto(url: String): Observable<Bitmap> = Observable.fromCallable {
    return@fromCallable Picasso.get().load(url).get()
}

override fun getPhoto() {
    auth.rxGetCurrentUser()
            .flatMap {
                val url = it.photoUrl.toString()
                return@flatMap dashboardFragmentModel.downloadPhoto(url)
                              .subscribeOn(Schedulers.io())
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                    { it -> v.setUserPhoto(it) },
                    { error -> Log.d("Photo download error", error.message) })
}