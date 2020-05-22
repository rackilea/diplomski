for (int i = 0; i < size; i++) {
// your month list is 0-based
    String month = charts_list_HadsM.get(i).month;
    mMonths[i] = month;
    String anx = charts_list_HadsM.get(i).anx;
    String dep = charts_list_HadsM.get(i).dep;


// Your data list is 1-based
// You add the data at (i+1) effectively skipping position 0
    e1.add(new Entry(i + 1, Integer.parseInt(anx)));
    e2.add(new Entry(i + 1, Integer.parseInt(dep)));


}