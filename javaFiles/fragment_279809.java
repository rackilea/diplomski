public class TestServlet extends HttpServlet {

private static final PublishSubject<String> o = PublishSubject.<String>create();

public static Observable<String> getServletObservable() {
    return o.observeOn(Schedulers.computation());
}

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
    synchronized (TestServlet.class) {
        o.onNext("value");
    }
}

}

class Foo {
public static void main(String[] args) {
    TestServlet.getServletObservable().map(new Func1<String, String>() {

        @Override
        public String call(String t1) {
            // do something
            return null;
        }

    }).groupBy(new Func1<String, String>() {

        @Override
        public String call(String t1) {
            // do something
            return null;
        }

    }).subscribe(new Observer<GroupedObservable<String, String>>() {

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(GroupedObservable<String, String> group) {
            group.observeOn(Schedulers.io()).subscribe(new Observer<String>() {

                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(String t) {
                    // store t
                }

            });
        }

    });
}
}