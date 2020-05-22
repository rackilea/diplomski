public class BH06_Graph_Frag extends Fragment{
private Runnable mTimer;
//i.e private LineGraphSeries<DataPoint> mSeries;

...

@Override
public void onResume() {
    super.onResume();

    mTimer = new Runnable() {
        @Override
        public void run() {

              //reception of value "x"
              //do something
              // i.e mSeries.resetData(new DataPoint[] {
              //    new DataPoint(6, x) });
              //    

            mHandler.postDelayed(this, 300);
        }
    };
    mHandler.postDelayed(mTimer, 300);
}