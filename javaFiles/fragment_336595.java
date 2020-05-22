int cnt = outputTable.getRowCount();
if(oneRadio.isSelected() && cnt > 0) {
    payAMT = payAMT * .01;
    for(int i = 0; i < cnt - 1; i++) {
        outputTable.setValueAt(payAMT, i, 4);
    }
}