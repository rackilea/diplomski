public class JobStatus {
  private boolean done;
  // other info
  // ...
}

public class JobStatusCallback<JobStatus> extends AsyncCallback {
    public final void onSuccess(JobStatus result) {
       if (result.isDone()) {
            done();
        } else {
            checkAgain();
        }
    }

    public final void onFailure(Throwable caught) {
       error(caught);
       checkAgain();
    }

    public void done() { // override
    }

    public void checkAgain() {
        service.checkStatus(this);
    }

    public void error(Thorwable t) { // override
    }
});