public void noExcelToExcel(String a) {
    char[] noExcel = a.toCharArray();
    char[] lin = null;
    char[] col = null;

    for (int i = 2; i <= 4; i++) {
        if (noExcel[i] == 'C') {

            lin = new char[i - 1];
            a.getChars(1, i, lin, 0);

            col = new char[i - 1];
            a.getChars(i + 1, a.length(), col, 0);

            break;
        }
    }

    if (lin == null || col == null) {
        // will be reached if there was no 'C' in noExcel
    }

    // do something with lin and col ...
}