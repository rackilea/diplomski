public static Detail newInstance(String time) {
        Detail fragment = new Detail();
        Bundle args = new Bundle();
        args.putString("time", time);
        fragment.setArguments(args);
        return fragment;
 }