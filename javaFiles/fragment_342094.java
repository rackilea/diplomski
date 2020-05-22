/**Sort a Sprite list relatively based on a specific sprite's location*/
public static ArrayList<Sprite> relativeSort(Sprite s0, ArrayList<Sprite> list) {             

    Comparator<Sprite> comp = new Comparator<Sprite>() {
        public int compare(Sprite s1, Sprite s2) {
            //return a positive number if s1 is closer to s0
            //return a negative number if s2 is closer to s0
        }
    };
    Collections.sort(list, comp);
    return list;
}