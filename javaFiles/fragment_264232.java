package com.est.framework.android.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sc.restclient.R;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomProgressDialog.
 */
public class CustomProgressDialog extends Dialog {

    /**
     * Instantiates a new custom progress dialog.
     *
     * @param context the context
     * @param theme the theme
     */
    public CustomProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    /* (non-Javadoc)
     * @see android.app.Dialog#onWindowFocusChanged(boolean)
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        ImageView imageView = (ImageView) findViewById(R.id.loadingImageView);
        AnimationDrawable yourAnimation = (AnimationDrawable) imageView.getBackground();
        yourAnimation.start();
    }

    /**
     * Creates the dialog.
     *
     * @param context the context
     * @param title the title
     * @param message the message
     * @return the custom progress dialog
     */
    public static CustomProgressDialog createDialog(Context context,String title) {
        CustomProgressDialog dialog = new CustomProgressDialog(context,android.R.style.Theme_Panel);
        dialog.setContentView(R.layout.dialogimg);

        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.MATCH_PARENT;
        dialog.getWindow().setLayout(width, height);

        TextView mloadMsg = (TextView)dialog.findViewById(R.id.loadMsg);
        if (title != null) {
            mloadMsg.setText(title);
        }else{
            mloadMsg.setVisibility(View.GONE);
        }
        dialog.getWindow().getAttributes().gravity = Gravity.CENTER;
        dialog.setCancelable(false);
        return dialog;
    }
}