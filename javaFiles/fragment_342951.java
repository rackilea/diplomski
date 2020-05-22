package br.com.bertan.swap.buttons;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SwapButtonsActivity extends Activity {

    // class declaration
    static ArrayList<Integer> numList = new ArrayList<Integer>();

    static ArrayList<Button> btnList = new ArrayList<Button>();

    public static void swap(ArrayList<Integer> list, int firstInd, int secondInd) {
        int temp = list.get(firstInd);
        list.set(firstInd, list.get(secondInd));
        list.set(secondInd, temp);
    }

    private void updateButtonStates(){

        int index_0 = -1;

        int index_up = -1;
        int index_down = -1;
        int index_left = -1;
        int index_right = -1;

        for(int i = 0; i < 16; i++){
            if(index_0 >= 0){   
                if(i != index_up
                   && i != index_down
                   && i != index_left
                   && i != index_right
//                 && i != index_0
                   ){
                    btnList.get(i).setEnabled(false);
                } else {
                    btnList.get(i).setEnabled(true);
                }
            } else {
                if(numList.get(i) == 0){
                    index_0 = i;

                    if(index_0 > 3){
                        index_up = index_0 - 4;
                    }

                    if(index_0 < 12){
                        index_down = index_0 + 4;
                    }

                    if(index_0 != 0
                       && index_0 != 4
                       && index_0 != 8
                       && index_0 != 12){
                        index_left = index_0 - 1;
                    }

                    if(index_0 != 3
                       && index_0 != 7
                       && index_0 != 11
                       && index_0 != 15){
                        index_right = index_0 + 1;
                    }

                    i = -1;
                }
            }
        }
    }

    public static void switchButtonValues(int buttonNum) {
        int index_0 = -1;
        int index_btn = -1;

        for(int i = 0; i < 16; i++){
            if(index_0 < 0){
                if(numList.get(i) == 0){
                    index_0 = i;
                }
            }

            if(index_btn < 0){
                if(buttonNum == btnList.get(i).getId()){
                    index_btn = i;
                }
            }

            if(index_0 >= 0 && index_btn >=0){
                break;
            }
        }

        btnList.get(index_0).setText(btnList.get(index_btn).getText().toString());
        btnList.get(index_btn).setText("0");

        numList.set(index_0, numList.get(index_btn));
        numList.set(index_btn, 0);
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // initialize ArrayList
        for(int i = 0; i < 16; i++){
            numList.add(i);
        }

        final Button btn_01 = (Button) findViewById(R.id.btn_01);
        final Button btn_02 = (Button) findViewById(R.id.btn_02);
        final Button btn_03 = (Button) findViewById(R.id.btn_03);
        final Button btn_04 = (Button) findViewById(R.id.btn_04);
        final Button btn_05 = (Button) findViewById(R.id.btn_05);
        final Button btn_06 = (Button) findViewById(R.id.btn_06);
        final Button btn_07 = (Button) findViewById(R.id.btn_07);
        final Button btn_08 = (Button) findViewById(R.id.btn_08);
        final Button btn_09 = (Button) findViewById(R.id.btn_09);
        final Button btn_10 = (Button) findViewById(R.id.btn_10);
        final Button btn_11 = (Button) findViewById(R.id.btn_11);
        final Button btn_12 = (Button) findViewById(R.id.btn_12);
        final Button btn_13 = (Button) findViewById(R.id.btn_13);
        final Button btn_14 = (Button) findViewById(R.id.btn_14);
        final Button btn_15 = (Button) findViewById(R.id.btn_15);
        final Button btn_16 = (Button) findViewById(R.id.btn_16);

        btnList.add(btn_01);
        btnList.add(btn_02);
        btnList.add(btn_03);
        btnList.add(btn_04);
        btnList.add(btn_05);
        btnList.add(btn_06);
        btnList.add(btn_07);
        btnList.add(btn_08);
        btnList.add(btn_09);
        btnList.add(btn_10);
        btnList.add(btn_11);
        btnList.add(btn_12);
        btnList.add(btn_13);
        btnList.add(btn_14);
        btnList.add(btn_15);
        btnList.add(btn_16);

        OnClickListener click_listener = new OnClickListener() {            
            @Override
            public void onClick(View v) {
                switch(v.getId()) {
                    case R.id.btn_01: {
                        switchButtonValues(R.id.btn_01);
                        btn_01.setText(String.valueOf(numList.get(0)));
                        updateButtonStates();
                        break;
                    }
                    case R.id.btn_02: {
                        switchButtonValues(R.id.btn_02);
                        btn_02.setText(String.valueOf(numList.get(1)));
                        updateButtonStates();
                        break;
                    }
                    case R.id.btn_03: {
                        switchButtonValues(R.id.btn_03);
                        btn_03.setText(String.valueOf(numList.get(2)));
                        updateButtonStates();
                        break;
                    }
                    case R.id.btn_04: {
                        switchButtonValues(R.id.btn_04);
                        btn_04.setText(String.valueOf(numList.get(3)));
                        updateButtonStates();
                        break;
                    }
                    case R.id.btn_05: {
                        switchButtonValues(R.id.btn_05);
                        btn_05.setText(String.valueOf(numList.get(4)));
                        updateButtonStates();
                        break;
                    }
                    case R.id.btn_06: {
                        switchButtonValues(R.id.btn_06);
                        btn_06.setText(String.valueOf(numList.get(5)));
                        updateButtonStates();
                        break;
                    }
                    case R.id.btn_07: {
                        switchButtonValues(R.id.btn_07);
                        btn_07.setText(String.valueOf(numList.get(6)));
                        updateButtonStates();
                        break;
                    }
                    case R.id.btn_08: {
                        switchButtonValues(R.id.btn_08);
                        btn_08.setText(String.valueOf(numList.get(7)));
                        updateButtonStates();
                        break;
                    }
                    case R.id.btn_09: {
                        switchButtonValues(R.id.btn_09);
                        btn_09.setText(String.valueOf(numList.get(8)));
                        updateButtonStates();
                        break;
                    }
                    case R.id.btn_10: {
                        switchButtonValues(R.id.btn_10);
                        btn_10.setText(String.valueOf(numList.get(9)));
                        updateButtonStates();
                        break;
                    }
                    case R.id.btn_11: {
                        switchButtonValues(R.id.btn_11);
                        btn_11.setText(String.valueOf(numList.get(10)));
                        updateButtonStates();
                        break;
                    }
                    case R.id.btn_12: {
                        switchButtonValues(R.id.btn_12);
                        btn_12.setText(String.valueOf(numList.get(11)));
                        updateButtonStates();
                        break;
                    }
                    case R.id.btn_13: {
                        switchButtonValues(R.id.btn_13);
                        btn_13.setText(String.valueOf(numList.get(12)));
                        updateButtonStates();
                        break;
                    }
                    case R.id.btn_14: {
                        switchButtonValues(R.id.btn_14);
                        btn_14.setText(String.valueOf(numList.get(13)));
                        updateButtonStates();
                        break;
                    }
                    case R.id.btn_15: {
                        switchButtonValues(R.id.btn_15);
                        btn_15.setText(String.valueOf(numList.get(14)));
                        updateButtonStates();
                        break;
                    }
                    case R.id.btn_16: {
                        switchButtonValues(R.id.btn_16);
                        btn_16.setText(String.valueOf(numList.get(15)));
                        updateButtonStates();
                        break;
                    }
                    default:
                        break;
                }
            }
        };

        // displays initial values on buttons
        for(int i = 0; i < 16; i++){
            btnList.get(i).setText(String.valueOf(numList.get(i)));
            btnList.get(i).setOnClickListener(click_listener);
        }

        updateButtonStates();
    }
}