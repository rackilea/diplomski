package company.tuyu.tuyu;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapterUserBooking extends ArrayAdapter<Bookings> {

private Bookings bookings;

private TextView user_book_total;

int selected_position = -1;

public ListAdapterUserBooking(Context context, ArrayList<Bookings> bookings) {
    super(context, R.layout.custom_user_bookinglistview, bookings);
}

@Override
public int getCount() {
    return super.getCount();
}

@NonNull
@Override
public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    bookings = getItem(position);

    LayoutInflater inf = LayoutInflater.from((getContext()));

    View customView = inf.inflate(R.layout.custom_user_bookinglistview, parent, false);

    final TextView serviceName = (TextView) customView.findViewById(R.id.custom_user_booking_serviceName);
    TextView servicePrice = (TextView) customView.findViewById(R.id.custom_user_booking_servicePrice);
    final CheckBox checkBox = (CheckBox) customView.findViewById(R.id.custom_user_booking_checkBox);

    user_book_total = (TextView) ((Activity) getContext()).findViewById(R.id.user_book_total);

    serviceName.setText(bookings.serviceName[position]);
    servicePrice.setText("£" + bookings.servicePrice[position]);

    final SharedPreferences sharedPreferences = getContext().getSharedPreferences("sharedPref", Context.MODE_PRIVATE);

    selected_position = sharedPreferences.getInt("selectedPosition", 0);
    checkBox.setChecked(selected_position == position);

    bookings.totalPrice = bookings.servicePrice[selected_position];
    bookings.selectedServiceID = bookings.ID[selected_position];
    bookings.selectedServicePrice = bookings.servicePrice[selected_position];

    user_book_total.setText("£" + bookings.totalPrice);

    checkBox.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            bookings.totalPrice = bookings.servicePrice[position];

            final boolean isChecked = checkBox.isChecked();
            if (isChecked) {
                selected_position = position;

                bookings.selectedServiceID = bookings.ID[position];
                bookings.selectedServicePrice = bookings.servicePrice[position];

                user_book_total.setText("£" + bookings.totalPrice);
            } else {
                selected_position = -1;

                user_book_total.setText("£" + "0" + ".00");
            }

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("selectedPosition", selected_position);
            editor.apply();

            notifyDataSetChanged();
        }
    });

    return customView;
    }
}