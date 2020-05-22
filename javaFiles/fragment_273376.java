package com.code.utilities;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class MVCArrayAdapter<ModelType> extends BaseAdapter {
    private final Activity ctx;
    public ArrayList<ModelType> array = new ArrayList<ModelType>();
    private Constructor<?> viewConstructor;

public MVCArrayAdapter(Activity context, String viewClassName)
        throws NoSuchMethodException, ClassNotFoundException {
    super();
    ctx = context;
    viewConstructor = Class.forName(viewClassName).getConstructor(
            Activity.class);

}

@Override
public int getCount() {
    return array.size();
}

public Object getItem(int position) {
    if (position < 0 || position >= array.size()) {
        throw new ArrayIndexOutOfBoundsException();// or something more
    } // specific to your API
    return array.get(position);

}

public long getItemId(int position) {
    return position;
}

@SuppressWarnings("unchecked")
public View getView(int position, View convertView, ViewGroup parent) {
    // ListViewRow<ModelType> view = (ListViewRow<ModelType>) convertView;

    try {
        final ListViewRow<ModelType> view = (ListViewRow<ModelType>) viewConstructor
                .newInstance(ctx);
        final MyHolder holder = new MyHolder(view);
        holder.childView.setModel((ModelType) getItem(position));
        view.setTag(holder);
        return view;
    } catch (IllegalArgumentException e) {
        e.printStackTrace();
    } catch (InstantiationException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    } catch (InvocationTargetException e) {
        e.printStackTrace();
    }

    return null;
}

public void add(ModelType object) {
    array.add(object);
}

public void addAll(Collection<? extends ModelType> objects) {
    array.addAll(objects);
}

public void addAll(ModelType... objects) {
    for (ModelType object : objects) {
        array.add(object);
    }
}

public void clear() {
    array.clear();
}

public void insert(ModelType object, int index) {
    array.set(index, object);
}

public void remove(ModelType object) {
    array.remove(object);
}

public void sort(Comparator<? super ModelType> comparator) {
    Collections.sort(array, comparator);
}

@SuppressWarnings("hiding")
public class MyHolder {

    ListViewRow<ModelType> childView = null;

    public MyHolder(ListViewRow<ModelType> view) {
        this.childView = view;
    }

}}