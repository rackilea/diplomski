/* Add a new Linearlayout as a container for the buttons */
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            //Added Weight Sum 8 in LinearLayout
            linearLayout.setWeightSum(8);
            /* Create a new Buttons in this container, for the status bar */
            //below LayoutParams define with weight 1 for buttons.
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);
            Button button1 = new Button(linearLayout.getContext());
            button1.setLayoutParams(param);

            Button button2 = new Button(linearLayout.getContext());
            button2.setLayoutParams(param);

            Button button3 = new Button(linearLayout.getContext());
            button3.setLayoutParams(param);

            Button button4 = new Button(linearLayout.getContext());
            button4.setLayoutParams(param);

            Button button5 = new Button(linearLayout.getContext());
            button5.setLayoutParams(param);

            Button button6 = new Button(linearLayout.getContext());
            button6.setLayoutParams(param);

            Button button7 = new Button(linearLayout.getContext());
            button7.setLayoutParams(param);

            Button button8 = new Button(linearLayout.getContext());
            button8.setLayoutParams(param);