public class Adapter extends BaseAdapter {

class LogInfo implements Serializable {


    public ArrayList<Point[][]> strokes;
    public LinkedList<byte[]> codes;
    public int[] times;
}

private LogInfo mInfo;
public Adapter(LogInfo info) {
    mInfo = info;
}



@Override
public int getCount() {
    if (mInfo != null && mInfo.strokes != null) {
    return mInfo.strokes.size();
    }
    return 0;
}

@Override
public Object getItem(int i) {
    return null;
}

@Override
public long getItemId(int i) {
    return 0;
}

@Override
public View getView(int i, View view, ViewGroup viewGroup) {
    if (mInfo != null) {
    Point[][] p = mInfo.strokes.get(i);
    byte[] b = mInfo.codes.get(i);
    //create the view
    }
    return null;
}