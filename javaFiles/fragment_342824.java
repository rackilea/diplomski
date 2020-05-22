public class MymarkerView extends MarkerView
{
    ArrayList<String> mXLabels;

    public MymarkerView(Context context, int layoutResource, ArrayList<String> xLabels) {
        super(context, layoutResource);
        mXLabels = xLabels;
    }

    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        //get x value
        String xVal= mXLabels.get(e.getXIndex());
    }

    @Override
    public int getXOffset(float xpos) {
        // this will center the marker-view horizontally
        return -(getWidth() / 2);

    }

    @Override
    public int getYOffset(float ypos) {
        // this will cause the marker-view to be above the selected value
        return -getHeight();
    }
}