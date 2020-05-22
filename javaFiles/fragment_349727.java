private static final String TYPE = "DATA_KEY";
public static  Tozihat newInstance(String type) {
         Tozihat fragment = new  Tozihat();
        Bundle args = new Bundle();
        args.putString(TYPE, type);

        fragment.setArguments(args);
        return fragment;
    }