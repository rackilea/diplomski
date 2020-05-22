package com.matthieu;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.FrameLayout.LayoutParams;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;
import java.util.Arrays;

public class DragActivity extends Activity implements View.OnTouchListener, AdapterView.OnItemLongClickListener
{
    private static final String TAG="DragActivity";

    private static final int NOT_DRAGGING = 0;
    private static final int DRAGGING = 1;

    private int state=NOT_DRAGGING;
    private ImageView draggable =null;
    private int dragged_position;

    float current_x, current_y;
    int current_icon = R.drawable.notepad;

    private ArrayList<String> names = new ArrayList<String>(Arrays.asList("Matt", "Xiaohui", "Yong", "Hunt", "Andy", "Ivy", "Guanglong", "Zeyan", "Yanxia",
            "Chris", "Mark", "Matthieu"));
    private ArrayList<Integer> icons = new ArrayList<Integer>(Arrays.asList( R.drawable.glasses, R.drawable.monkey, R.drawable.normal, R.drawable.smile, R.drawable.wink));
    private ArrayList<Integer> matching;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setupListContent();

        ListView list = (ListView) findViewById(R.id.main_list);
        list.setAdapter(new DragListAdapter());
        list.setOnItemLongClickListener(this);

        list.setOnTouchListener(this);

        ImageView image = (ImageView) findViewById(R.id.main_image);
        image.setImageResource(current_icon);
    }

    private void setupListContent() {
        matching = new ArrayList<Integer>();
        for (int i=0; i<names.size(); i++) {
            matching.add((int) (icons.size() * Math.random()));
        }
    }

    @SuppressWarnings("unchecked")
    private class DragListAdapter extends ArrayAdapter {
        public DragListAdapter() {
            super(DragActivity.this, R.layout.list_item, names);

        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            if (row == null) {
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.list_item, parent, false);
            }

            row.setDrawingCacheEnabled(true);
            TextView name = (TextView) row.findViewById(R.id.item_text);
            ImageView icon = (ImageView) row.findViewById(R.id.item_icon);

            name.setText(names.get(position));
            icon.setImageResource(icons.get(matching.get(position)));

            return row;
        }
    }

    private boolean checkOnDropIcon(MotionEvent me) {
        ImageView drop_icon = (ImageView) findViewById(R.id.main_image);
        Rect icon_rect = new Rect();
        drop_icon.getGlobalVisibleRect(icon_rect);
        Log.d(TAG, "icon at " + icon_rect.left + "<- ->" + icon_rect.right + ", " +
                icon_rect.top + " ^ v" + icon_rect.bottom);
        if ((me.getRawX()<icon_rect.left) || (me.getRawX()>icon_rect.right) ||
                (me.getRawY()<icon_rect.top) || (me.getRawY()>icon_rect.bottom)) {
            return false;
        }
        else {
            return true;
        }
    }

    private void checkOnDrop(MotionEvent me) {
        boolean onDropIcon = checkOnDropIcon(me);
        ImageView image = (ImageView) findViewById(R.id.main_image);
        if ((onDropIcon) && (current_icon==R.drawable.notepad)) {
            current_icon = R.drawable.exit;
            image.setImageResource(current_icon);
            image.invalidate();
            return;
        }
        if ((!onDropIcon) && (current_icon==R.drawable.exit)) {
            current_icon = R.drawable.notepad;
            image.setImageResource(current_icon);
            image.invalidate();
            return;
        }
    }

    public boolean onTouch(View view, MotionEvent me) {
        if (state == NOT_DRAGGING) {
            // get the position of the touch so we know where to place the dragging item if it is a long press
            current_x = me.getRawX();
            current_y = me.getRawY();
            return false;
        }
        else {
            FrameLayout frame = (FrameLayout) findViewById(R.id.drag_space);

            if (me.getAction()==MotionEvent.ACTION_UP) {
                frame.removeAllViews();
                draggable=null;
                frame.setVisibility(View.GONE);
                state=NOT_DRAGGING;

                // check if we dropped a name
                if (checkOnDropIcon(me)) {
                    names.remove(dragged_position);
                    matching.remove(dragged_position);

                    ListView list = (ListView) findViewById(R.id.main_list);
                    DragListAdapter adapter = (DragListAdapter) list.getAdapter();
                    adapter.notifyDataSetChanged();
                }

                // restore the icon
                ImageView image = (ImageView) findViewById(R.id.main_image);

                current_icon = R.drawable.notepad;
                image.setImageResource(current_icon);
                image.invalidate();
            }
            if (me.getAction()==MotionEvent.ACTION_MOVE) {
                int frame_position[] = new int[2];
                frame.getLocationOnScreen(frame_position);

                draggable.setPadding(
                        (int) me.getRawX()-frame_position[0]-(draggable.getDrawable().getIntrinsicWidth()/2),
                        (int) me.getRawY()-frame_position[1]-(draggable.getDrawable().getIntrinsicHeight()/2),
                        0, 0);
                draggable.invalidate();

                checkOnDrop(me);
            }

            return true;
        }
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (state == DRAGGING) {
            Log.d(TAG, "already have an object moving... ?");
            return false;
        }

        FrameLayout frame = (FrameLayout) findViewById(R.id.drag_space);
        int frame_position[] = new int[2];
        frame.getLocationOnScreen(frame_position);

        // setup everything for dragging
        state = DRAGGING;
        dragged_position = i;

        draggable = new ImageView(this);
        Bitmap bm = view.getDrawingCache();
        draggable.setImageBitmap(bm);
        draggable.setAlpha(150);
        draggable.setScaleType(ImageView.ScaleType.CENTER);
        draggable.setDrawingCacheEnabled(true);
        draggable.setPadding((int) current_x-frame_position[0]-(bm.getWidth()/2), (int) current_y-frame_position[1]-(bm.getHeight()/2), 0, 0);

        frame.setVisibility(View.VISIBLE);
        frame.addView(draggable, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        return true;
    }
}