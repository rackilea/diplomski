int iNumberOfButtons =  productTypeList.size();
Button[] dynamicButtons = new Button[iNumberOfButtons];

LinearLayout.LayoutParams paramsButton = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

for (int i = 0; i < iNumberOfButtons; i++) {
    ProductType productType = productTypeList.get(i);
    dynamicButtons[i] = new Button(getActivity());
    dynamicButtons[i].setText(productType.getTitleString());
    dynamicButtons[i].setId(i);
    dynamicButtons[i].setTextSize(15.0f);
    dynamicButtons[i].setOnClickListener(this);
    dynamicButtons[i].setLayoutParams(paramsButton);
    dynamicButtonsLinearLayout.addView(dynamicButtons[i]); // dynamicButtonsLinearLayout is the container of the buttons
}