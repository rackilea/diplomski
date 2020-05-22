import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder>{

private Context context;
private List<ImageSugarPojo> categoryObject;

public CategoryAdapter(Context context, List<ImageSugarPojo> categoryObject) {
    this.context = context;
    this.categoryObject = categoryObject;
}

@Override
public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_category_list, parent, false);
    return new CategoryViewHolder(layoutView);
}

@Override
public void onBindViewHolder(CategoryViewHolder holder, int position) {
    final ImageSugarPojo catObject = categoryObject.get(position);
    holder.categoryName.setText(catObject.getText());
    int resId = getResourseId(context, "drawable", catObject.getImage(), context.getPackageName());
}

@Override
public int getItemCount() {
    return categoryObject.size();
}

public static int getResourseId(Context context, String pVariableName, String pResourcename, String pPackageName) throws RuntimeException {
    try {
        return context.getResources().getIdentifier(pVariableName, pResourcename, pPackageName);
    } catch (Exception e) {
        throw new RuntimeException("Error getting Resource ID.", e);
    }
}
}