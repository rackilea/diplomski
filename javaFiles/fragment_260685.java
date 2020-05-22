import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter{

    private list_cons[] data;
    private static LayoutInflater inflater=null;

    public CustomAdapter(Context context, list_cons[] data){
        this.data=data;
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount(){
        return data.length;
    }

    public Object getItem(int position){
        return data[position];
    }

    public long getItemId(int position){
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        View current= convertView;
        if(convertView==null)
            current = inflater.inflate(R.layout.list_item,null);

        TextView name = (TextView) current.findViewById(R.id.genre_name);
        ImageView imag = (ImageView) current.findViewById(R.id.list_image);

        //Setting all values in ListView

        name.setText(data[position].title);
        imag.setImageResource(data[position].image_id);

        return current; 

    }//end of method getView :)

}