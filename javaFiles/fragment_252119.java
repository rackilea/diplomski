package com.example.example;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity implements OnClickListener {

 private ListView listView;
 ArrayList<String> messages;
 ArrayAdapter<String> adapter;

 @Override
 protected void onCreate(Bundle savedInstanceState) {

  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);

  setTitle("Setted title");

  listView = (ListView) findViewById(R.id.messagesList);
  messages = new ArrayList<String>();
  adapter = new ArrayAdapter(this, R.layout.message_list_row,
    R.id.messagesList, messages);

  listView.setAdapter(adapter);

  Button sendmessage = (Button) findViewById(R.id.sendMessage);
  sendmessage.setOnClickListener(this);

 }

 @Override
 public void onClick(View view) {
  System.out.println(messages == null);
  messages.add("Anything");
  adapter.notifyDataSetChanged();
 }
}