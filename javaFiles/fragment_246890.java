package com.example.pbp22.dogbreed;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Product> {

    List<Product> products;
    Context context;
    int resource;

    public CustomAdapter(Context context, int resource, List<Product> products) {
        super(context, resource, products);
        this.products = products;
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_row, null, true);

        }
        Product product = getItem(position);

        ImageView image = (ImageView) convertView.findViewById(R.id.image);
        Picasso.with(context).load(product.getImage()).into(image);

        TextView breedName = (TextView) convertView.findViewById(R.id.breedName);
        breedName.setText(product.getBreedName());


        return convertView;
    }

}