ParsedExampleDataSet dataItem;
while(i.hasNext()){

 dataItem = i.next();
 someTextView1.setText(dataItem.getFileURL());
 anotherTextView.setText(dataItem.getAddress());

}

... etc.