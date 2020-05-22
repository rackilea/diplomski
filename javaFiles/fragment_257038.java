package com.leccles.swipetabs;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * 
 */
public class FragmentA extends Fragment implements
    GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
Button lapButton;
TextView timerText;
ListView lapListView;
TextView mMilliTextView;
String milliText;
long startTime = 0;
String sPauseTime;
long iPauseTime;
long timeInMilliSeconds = 0;
GestureDetectorCompat gDetector;

Handler timerHandler = new Handler();
Runnable pauseRunnable = new Runnable() {

    @Override
    public void run() {
        long millis = System.currentTimeMillis() + startTime;
        int seconds = (int) (millis / 1000);
        int minutes = seconds / 60;
        seconds = seconds % 60;

        timerText.setText(String.format("%02d:%02d", minutes, seconds));
        timerHandler.postDelayed(this, 500);

    }
};

Runnable timerRunnable = new Runnable() {

    @Override
    public void run() {
        long millis = System.currentTimeMillis() - startTime;
        int seconds = (int) (millis / 1000);
        int minutes = seconds / 60;
        seconds = seconds % 60;

        timerText.setText(String.format("%02d:%02d", minutes, seconds));
        timerHandler.postDelayed(this, 500);
    }

};

public FragmentA() {
    // Required empty public constructor
}

@Override
public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    // Inflate the layout for this fragment
    mMilliTextView = (TextView) getView().findViewById(R.id.milliTextView);
    lapButton = (Button) getView().findViewById(R.id.lapButton);
    timerText = (TextView) getView().findViewById(R.id.timerText);
    lapListView = (ListView) getView().findViewById(R.id.lapListView);

    this.gDetector = new GestureDetectorCompat(getActivity(), this);

    timerText.setOnTouchListener(new OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            gDetector.onTouchEvent(event);
            return true;
        }
    });

    /*
     * timerText.setOnClickListener(new View.OnClickListener() {
     * 
     * @Override public void onClick(View v) { TextView timerText =
     * (TextView) v; if (timerText.getText().equals(
     * getView().findViewById(R.string.stopWatchTime))) {
     * timerHandler.removeCallbacks(timerRunnable);
     * 
     * } else {
     * 
     * startTime = System.currentTimeMillis();
     * timerHandler.postDelayed(timerRunnable, 0);
     * 
     * }
     * 
     * }
     * 
     * });
     */
}

@Override
public boolean onSingleTapConfirmed(MotionEvent e) {
    sPauseTime = timerText.getText().toString();
    startTime = System.currentTimeMillis();
    timerHandler.postDelayed(timerRunnable, 0);

    return true;
}

@Override
public boolean onDoubleTap(MotionEvent e) {
    sPauseTime = timerText.getText().toString();
    timerHandler.removeCallbacks(timerRunnable);

    return true;
}

@Override
public boolean onDoubleTapEvent(MotionEvent e) {
    // TODO Auto-generated method stub
    return true;
}

@Override
public boolean onDown(MotionEvent e) {
    // TODO Auto-generated method stub
    return true;
}

@Override
public void onShowPress(MotionEvent e) {
    // TODO Auto-generated method stub

}

@Override
public boolean onSingleTapUp(MotionEvent e) {
    // TODO Auto-generated method stub
    return true;
}

@Override
public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
        float distanceY) {
    // TODO Auto-generated method stub
    return true;
}

@Override
public void onLongPress(MotionEvent e) {
    timerHandler.removeCallbacks(timerRunnable);
    timerText.setText("00:00");

}

@Override
public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
        float velocityY) {
    // TODO Auto-generated method stub
    return true;
}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    return inflater.inflate(R.layout.fragment_a, container, false);
}