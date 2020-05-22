protected ArrayList<ArrayList<Integer>> splitter(int [] payload, int splits)
{
    ArrayList<Integer> segment = null;

    ArrayList<ArrayList<Integer>> assembledArray = new ArrayList<ArrayList<Integer>>();
    int steps = payload.length / splits;


    for(int i=0; i<payload.length; i++) {

        if (segment == null) {
            segment = new ArrayList<Integer>();
            assembledArray.add(segment);
        }

        segment.add(payload[i]);

        if ((segment.size()>=steps) && (assembledArray.size() < splits))
            // null out the segment to indicate a new one must be created
            // unless we are on the last split index
            segment = null;
    }
}
return assembledArray;