public class DragListener extends Activity implements View.OnDragListener {

@Override
public boolean onDrag(View v, DragEvent event)
{
    final int action = event.getAction();
    switch (action) {
        case DragEvent.ACTION_DRAG_STARTED: {
            Log.e("DRaG2", "START");
            return true;
        }
        case DragEvent.ACTION_DRAG_ENDED: {
            Log.e("DRaG2", "ENDED");
            return true;
        }
        case DragEvent.ACTION_DRAG_ENTERED: {
            Log.e("DRaG2", "ETER");
            return true;
        }
        case DragEvent.ACTION_DRAG_EXITED: {
            Log.e("DRaG2", "EXIT");
            return true;
        }
        case DragEvent.ACTION_DROP: {
            if (v.getId() == R.id.imageView1)
            {
                ClipData.Item item = event.getClipData().getItemAt(0);
                Log.e("ITEM", item.getText().toString());
                Log.e("DRaG2", String.valueOf(v.getId()));


            }

            else if (v.getId() == R.id.imageView2)
            {
                ClipData.Item item = event.getClipData().getItemAt(0);
                Log.e("ITEM", item.getText().toString());
                Log.e("DRaG2", String.valueOf(v.getId()));
            }

            else if (v.getId() == R.id.imageView3)
            {
                ClipData.Item item = event.getClipData().getItemAt(0);
                Log.e("ITEM", item.getText().toString());
                Log.e("DRaG2", String.valueOf(v.getId()));
            }
            return true;
        }
    }
    return false;
}