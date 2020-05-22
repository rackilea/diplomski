package com.example.sqlitedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;

public class SMSDataRepo {
    private DBHelper dbHelper;

    public SMSDataRepo(Context context) {
        dbHelper = new DBHelper(context);
    }

    public int insert(SMSData sMSData) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SMSData.KEY_number, sMSData.number);
        values.put(SMSData.KEY_message,sMSData.message);

        // Inserting Row
        long SMSData_Id = db.insert(SMSData.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) SMSData_Id;
    }

    public void delete(int SMSData_Id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // It's a good practice to use parameter ?, instead of concatenate string
        db.delete(SMSData.TABLE, SMSData.KEY_ID + "= ?", new String[] { String.valueOf(SMSData_Id) });
        db.close(); // Closing database connection
    }

    public void update(SMSData sMSData) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(SMSData.KEY_number, sMSData.number);
        values.put(SMSData.KEY_message,sMSData.message);

        // It's a good practice to use parameter ?, instead of concatenate string
        db.update(SMSData.TABLE, values, SMSData.KEY_ID + "= ?", new String[] { String.valueOf(SMSData.SMSData_ID) });
        db.close(); // Closing database connection
    }

    public ArrayList<HashMap<String, String>>  getSMSDataList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                SMSData.KEY_ID + "," +
                SMSData.KEY_number+                     
                SMSData.KEY_message+ "," +
                " FROM " + SMSData.TABLE;

        //SMSData sMSData= new SMSData();
        ArrayList<HashMap<String, String>> sMSDataList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> sMSData= new HashMap<String, String>();
                sMSData.put("number", cursor.getString(cursor.getColumnIndex(SMSData.KEY_number)));
                sMSData.put("message", cursor.getString(cursor.getColumnIndex(SMSData.KEY_message)));
                sMSDataList.add(sMSData);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return sMSDataList;

    }

    public SMSData getSMSDataById(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                SMSData.KEY_ID + "," +
                SMSData.KEY_number + "," +
                SMSData.KEY_message +
                " FROM " + SMSData.TABLE
                + " WHERE " +
                SMSData.KEY_ID + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount =0;
        SMSData sMSData= new SMSData();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                sMSData.SMSData_ID =cursor.getInt(cursor.getColumnIndex(SMSData.KEY_ID));
                sMSData.number=cursor.getInt(cursor.getColumnIndex(SMSData.KEY_number));
                sMSData.message=cursor.getString(cursor.getColumnIndex(SMSData.KEY_message));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return sMSData;
    }

}