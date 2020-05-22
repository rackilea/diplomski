package com.example.zohaib.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBConnection extends SQLiteOpenHelper {
    // change version with change in schema or db changes
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "products.db";
    private static final String TABLE_PRODUCTS = "products";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_PRODUCTNAME = "productName";



    public DBConnection(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTable(db);
        Log.d("From onCreate : ", " successfully created.");
    }

    private void createTable(SQLiteDatabase db) {
        String query ="CREATE TABLE " + TABLE_PRODUCTS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PRODUCTNAME + " TEXT " +
                ");";
        db.execSQL(query);
        Log.d("Create Database:", "Successful");

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_PRODUCTNAME, "Sample Data");
        db.insert(TABLE_PRODUCTS, null, contentValues);
        Log.d("Insert Row:", "Insert Row Successful");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        createTable(db);
        Log.d("From onUpgrade : ", " successfully upgraded.");
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        createTable(db);
        Log.d("From onDowngrade : ", " successfully Downgraded.");
    }
}