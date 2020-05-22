package com.example.bankapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.bankapp.BankAccount;
import com.example.bankapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TransferOwnAccount extends AppCompatActivity {

    private Spinner accountFrom, accountTo;
    private EditText transferAmount;
    private FirebaseDatabase database;
    static  ArrayList<BankAccount> accounts = new ArrayList<>();
    ArrayAdapter<BankAccount> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_own_account);
        init();
        loadAccounts();

    }

    public void transferMoney(View view) {
        Log.d("test", "olool" + accountFrom.getSelectedItem().toString());
    }

    public void loadAccounts() {
        Intent getIntent = getIntent();
        String userCPR = getIntent.getStringExtra("CPR");
        DatabaseReference dbref = database.getReference("usersbankaccounts/" + userCPR);
        dbref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    DatabaseReference bankaccounts = database.getReference("bankaccounts/" + data.getKey());
                    Log.d("test", data.getKey());
                    bankaccounts.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            BankAccount bankAccount = dataSnapshot.getValue(BankAccount.class);
                            accounts.add(bankAccount);
                            adapter.notifyDataSetChanged();

                            Log.d("test", "" + accounts);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
                Log.d("test", "" + accounts);


                adapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void init() {
        this.adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, accounts);
        this.accountFrom = findViewById(R.id.transferFromSpinner);
        this.accountTo = findViewById(R.id.transferToSpinner);
        this.transferAmount = findViewById(R.id.transferAmount);
        this.database = FirebaseDatabase.getInstance();
        this.accountFrom.setAdapter(adapter);
        this.accountTo.setAdapter(adapter);

    }
}