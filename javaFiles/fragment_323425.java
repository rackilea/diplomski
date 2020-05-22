@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment

    View RootView1 = inflater.inflate(R.layout.fragment_diary, container, false);

    ImageView imageView = (ImageView) RootView.findViewById(R.id.image_fir);
    String[] colorlist = getResources().getStringArray(R.array.colors);
    String color = colorlist[randInt(0, (colorlist.length - 1)))]
    imageView.setBackgroundColor(Color.parseColor(color));
    return RootView1;
}

public static int randInt(int min, int max) {

        // Usually this can be a field rather than a method variable
        Random rand = new Random();
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }