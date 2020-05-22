package com.gujrat.quiz.qrcodereader;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.activeandroid.query.Select;
import com.activeandroid.query.Update;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class MenuActivity extends AppCompatActivity {

    private String[] qrDescription = {"01234", "56789", "02468", "13579"};
    private static final int MY_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button read = (Button) findViewById(R.id.read);
        Button show = (Button) findViewById(R.id.show);
        Button clear= (Button) findViewById(R.id.clear);

        if (getAll().size() == 0) {
            saveInitialDataToDatabase();
        } else {
//            Toast.makeText(this, getAll().size() + "", Toast.LENGTH_SHORT).show();
        }

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{Manifest.permission.CAMERA},
                                MY_REQUEST_CODE);
                    } else {
                        startActivity(new Intent(MenuActivity.this, MainActivity.class));
                    }
                } else {
                    startActivity(new Intent(MenuActivity.this, MainActivity.class));
                }

            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, ShowReadQrCodeActivity.class));
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    List<QRDataHelper> scannedProductList = getAlreadyScannedList();
                    for (int i = 0; i < scannedProductList.size(); i++) {
                        updateDatabase(scannedProductList.get(i));
                    }
                    Toast.makeText(MenuActivity.this, "List Cleared", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(MenuActivity.this, "List Empty", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//             Now user should be able to use camera
                startActivity(new Intent(MenuActivity.this, MainActivity.class));
            } else {
                // Your app will not have this permission. Turn off all functions
                // that require this permission or it will force close like your
                // original question
            }
        }
    }

    private void saveInitialDataToDatabase() {
        try {
            for (int i = 0; i < qrDescription.length; i++) {
                QRDataHelper qrDataHelper = new QRDataHelper();
                qrDataHelper.setProduct_id(i + "");
                qrDataHelper.setProduct_description(qrDescription[i]);
                qrDataHelper.setProduct_used("0");
                qrDataHelper.save();
            }
        } finally {
//
        }
    }

    public static List<QRDataHelper> getAll() {
        return new Select()
                .from(QRDataHelper.class)
                .where("1")
                .execute();
    }

    public static List<QRDataHelper> getAlreadyScannedList() {
        return new Select()
                .from(QRDataHelper.class)
                .where("product_used = 1")
                .execute();
    }

    public static void updateDatabase(QRDataHelper qrDataHelper) {
        new Update(QRDataHelper.class)
                .set("product_used = 0")
                .where("product_id = ?", qrDataHelper.getProduct_id())
                .execute();
    }


}