public static Integer[] convertFiletoIntegerArray(int id, Context activity)
        throws NotFoundException, NumberFormatException {

    List<Integer> vector = new ArrayList<Integer>();

    InputStream in = activity.getResources().openRawResource(id);
    Scanner sc = new Scanner(new InputStreamReader(in));

    while (sc.hasNext()) {

        vector.add(Integer.parseInt(sc.nextLine()));
    }

    Integer[] splVector = vector.toArray(new Integer[0]);
    return splVector;
}