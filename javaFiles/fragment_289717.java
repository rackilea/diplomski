import android.widget.Toast

int add(int i, int j){
    return i+j;
}

int i=add(1, 5);
Toast.makeText(context, ""+i, 5000).show();