class Wrapper {
    public List< MainTag > MAIN_TAG = new ArrayList<>();

    public void sort(final int byTag) {
        Collections.sort(MAIN_TAG, new Comparator< MainTag >() {
            @Override
            public int compare(MainTag m1, MainTag m2) {
                switch (byTag) {
                    case 1: return m1.TAG_ONE.compareTo(m2.TAG_ONE);
                    case 2: return m1.TAG_TWO.compareTo(m2.TAG_TWO);
                    case 3: return m1.TAG_THREE.compareTo(m2.TAG_THREE);
                    case 4: return m1.TAG_FOUR.compareTo(m2.TAG_FOUR);
                    case 5: return m1.TAG_FIVE.compareTo(m2.TAG_FIVE);
                    case 6: return m1.TAG_SIX.compareTo(m2.TAG_SIX);
                }
                return 0;
            }
        });
    }
}

class MainTag {
    public Integer TAG_ONE;
    public Integer TAG_TWO;
    public String TAG_THREE;
    public Integer TAG_FOUR;
    public String TAG_FIVE;
    public String TAG_SIX;
}