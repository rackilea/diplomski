String feedUrl = "https://somepath.com/terminallocation/";

final play.libs.F.Promise<Result> resultPromise = WS.url(feedUrl)
        .setQueryParameter("msisdn", number)
        .setAuth("48509237274", "Y7A7HNM3EFF3LF", com.ning.http.client.Realm.AuthScheme.BASIC).get()
        .map(new Function<WS.Response, Result>() {
                    return ok("");                  
});