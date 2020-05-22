private Object lock = new Object();
private Set<Call> calls = new HashSet<>();
private ProgressDialog progressDialog;

void addCall(Call call) {
    synchronized(lock) {
        calls.add(call);
        if (calls.size() == 1) {
            progressDialog.show();
        }
    }
}

void removeCall(Call call) {
    synchronized(lock) {
        calls.remove(call);
        if (calls.size() == 0) {
            progressDialog.hide();
        }
    }
}