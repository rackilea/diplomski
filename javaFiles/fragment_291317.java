package com.example.linkedin;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.MediaColumns;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Take_Snap_Page extends Activity
{
    ImageView imgPersonalSnap;
    ImageView imgAddressProofSnap;
    ImageView imgPanCardProofSnap;
    ImageView imgHideBitmap;

    Button btnPersonal ;
    Button btnAddress;
    Button btnPanCard;
    Button btnSubmitSnap;

    Bitmap bp;
    Bitmap bitmap ;

    private int FIRSTCLICK=1;
    private int SECONDCLICK=2;
    private int THIEDCLICK=3;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.take_snap);

        imgPersonalSnap = (ImageView)findViewById(R.id.imagesPersonnalSnap);
        imgAddressProofSnap = (ImageView)findViewById(R.id.imageAddressProofSnap);
        imgPanCardProofSnap = (ImageView)findViewById(R.id.imagePanCardproofSnap);
        imgHideBitmap = (ImageView)findViewById(R.id.imgHide);



        btnPersonal = (Button)findViewById(R.id.buttonCapture_Personal_Snap);
        btnPersonal.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                open(FIRSTCLICK);
            }
        });




        btnAddress = (Button)findViewById(R.id.buttonCapture_AddressSnap);
        btnAddress.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                open(SECONDCLICK);

            }
        });



        btnPanCard = (Button)findViewById(R.id.buttonCapture_PanCardSnap);
        btnPanCard.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                open(THIEDCLICK);

            }
        });

    }


    public void open(int requestCode) {
        Intent intent = new Intent(
                android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, requestCode);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) 
    {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == FIRSTCLICK)
        {
            if (resultCode == RESULT_OK && data !=null )
            {
                // ... now let's see use the picture at data/
                imgPersonalSnap.setImageBitmap(decodeFile(getAbsolutePath(data.getData())));
            }
        }else if (requestCode == FIRSTCLICK)
        {
            if (resultCode == RESULT_OK && data !=null )
            {
                // ... now let's see use the picture at data/
                imgAddressProofSnap.setImageBitmap(decodeFile(getAbsolutePath(data.getData())));
            }
        }else if (requestCode == FIRSTCLICK)
        {
            if (resultCode == RESULT_OK && data !=null )
            {
                // ... now let's see use the picture at data/
                imgPanCardProofSnap.setImageBitmap(decodeFile(getAbsolutePath(data.getData())));
            }
        }
    }

    public String getAbsolutePath(Uri uri) {
        String[] projection = { MediaColumns.DATA };
        @SuppressWarnings("deprecation")
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        if (cursor != null) {
            int column_index = cursor.getColumnIndexOrThrow(MediaColumns.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } else
            return null;
    }

    public Bitmap decodeFile(String path) {
        try {
            // Decode image size
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(path, o);
            // The new size we want to scale to
            final int REQUIRED_SIZE = 70;

            // Find the correct scale value. It should be the power of 2.
            int scale = 1;
            while (o.outWidth / scale / 2 >= REQUIRED_SIZE && o.outHeight / scale / 2 >= REQUIRED_SIZE)
                scale *= 2;

            // Decode with inSampleSize
            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            return BitmapFactory.decodeFile(path, o2);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;

    }

}