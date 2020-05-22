String[] keyVal = value.spilt("\t",2);

Path filePath = ((FileSplit) context.getInputSplit()).getPath();
String dirName = filePath.getParent().getName().toString();

Text outValue = new Text();
if(dirName.equals("mr_out_1")){
    outValue.set("1_" + keyVal[1]);
} else if(dirName.equals("mr_out_2")){
    outValue.set("2_" + keyVal[1]);
} else {
    outValue.set("3_" + keyVal[1]);
}

context.write(new Text(keyVal[0]), outVal);