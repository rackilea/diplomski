@WebServlet(name="myServlet",
             urlPatterns={"/mySlowProcess"},
             asyncSupported=true) // asyncSupported MUST be specified for
                                  // servlets that support asynchronous
                                  // processing
public class MyAwesomeServlet extends HttpSerlvet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {


        // an AsyncContext is created, now the response will be completed
        // not when doGet finalizes its execution, but when
        // myAsyncContext.complete() is called.
        AsyncContext myAsyncContext = request.startAsync(request, response);

        // ...

        // myAsyncContext is passed to another thread
        delegateExecutionToProcessingThread(myAsyncContext);

        // done, now this thread is free to serve another request
    }

}

// ... and somewhere in another part of the code:

public class MyProcessingObject {

    public void doSlowProcess() {

        // ...

        runSlowProcess();
        myAsyncContext.complete(); // request is now completed.

        // ...

    }

}