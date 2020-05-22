package pk.sohail.gallerytest.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.lang.reflect.Field;

import pk.sohail.gallerytest.R;

public class MainActivity extends Activity {

    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(context, view);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // TODO Auto-generated method stub
                        switch (item.getItemId()) {
                            case R.id.one:
                                Toast.makeText(getApplicationContext(), "1",
                                        Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.two:
                                Toast.makeText(getApplicationContext(), "2",
                                        Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.three:
                                Toast.makeText(getApplicationContext(), "3",
                                        Toast.LENGTH_SHORT).show();
                                return true;
                        }
                        return false;
                    }
                });
                popupMenu.inflate(R.menu.main);
                // Force icons to show
                Object menuHelper;
                Class[] argTypes;

                try {
                    Field fMenuHelper = PopupMenu.class.getDeclaredField("mPopup");
                    fMenuHelper.setAccessible(true);
                    menuHelper = fMenuHelper.get(popupMenu);
                    argTypes = new Class[]{boolean.class};
                    menuHelper.getClass()
                            .getDeclaredMethod("setForceShowIcon", argTypes)
                            .invoke(menuHelper, true);
                } catch (Exception e) {
                    // Possible exceptions are NoSuchMethodError and
                    // NoSuchFieldError
                    //
                    // In either case, an exception indicates something is wrong
                    // with the reflection code, or the
                    // structure of the PopupMenu class or its dependencies has
                    // changed.
                    //
                    // These exceptions should never happen since we're shipping the
                    // AppCompat library in our own apk,
                    // but in the case that they do, we simply can't force icons to
                    // display, so log the error and
                    // show the menu normally.

                    Log.w("as", "error forcing menu icons to show", e);
                    popupMenu.show();
                    return;
                }

                popupMenu.show();
            }
        });

    }
}