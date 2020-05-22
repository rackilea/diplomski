public class BaseFragment extends Fragment {
public Data data;
public Adapter adapter;
        public void clear() {
            data.clear();
            adapter.notifyDataSetChanged();
        }
    }