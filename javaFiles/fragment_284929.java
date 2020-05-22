public class ScreenSlidePageFragment extends Fragment {
int layout;
public void setContent(int layout){  
   this.layout=layout;
}
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    ViewGroup rootView = (ViewGroup) inflater.inflate(layout, container, false);

    return rootView;
}
}