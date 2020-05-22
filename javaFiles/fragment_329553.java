public void BubbleSort() {

    Spannable spn = enterNum.getText();
    for (int i = 0; i < spn.length(); i++){
        num[i] = Integer.parseInt(""+spn.charAt(i));
    }

    for (i = 0; i < num.length; i++) {
        for (j = i + 1; j < num.length; j++) {
            if (num[i] > num[j]) {
                temp = num[i];
                num[i] = num[j];
                num[j] = temp;
            }
        }
    }

    String result = "";
    for (int i = 0; i < spn.length(); i++){
        result += num[i];
    }
    sortedNum.setText(result);

}