public class MyTaskFragment extends Fragment {
    private TaskCallbacks mCallbacks;
    private Task mTask;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallbacks = (TaskCallbacks) activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retain this fragment across configuration changes.
        setRetainInstance(true);

        // Create and execute the background task.
        mTask = new Task();
        mTask.execute();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    private class Task extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            mCallbacks.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            // do stuff
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            mCallbacks.onPostExecute();
        }
    }

    public static interface TaskCallbacks {
        void onPreExecute();
        void onPostExecute();
    }
}