List<String> stringList = new ArrayList<>();
stringList.add("2");
stringList.add("3");
stringList.add("5");

double[] doubleList = new double[StringList.size()]; 
double sum = 0;
for (int i = 0; i < StringList.size(); ++i) { 
    doubleList[i] = Double.parseDouble(StringList.get(i)); 
    sum += doubleList[i];
}

textView.setText(sum);