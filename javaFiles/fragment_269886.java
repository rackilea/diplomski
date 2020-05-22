public class MyFragment extends FragmentActivity {

        private void delegateMethod(Object result) {
            TaskB b = new TaskB();
            b.doanotherthing(result);
        }

        class TaskA {
            ...
            public void onPostExecute() {
                Object result = new Object();
                delegateMethod(result);
            }
        }

        class TaskB {
            public void doanotherthing(Object o) {
                ...
            }
        }
    }