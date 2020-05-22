public static class Reduce extends MapReduceBase implements Reducer<Text, Text, Text, Text> {

    public void reduce(Text key, Iterator<Text> values, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        //-----Modified section START-----------
        List<String> dateList = new ArrayList<String>();

        for(Iterator<Text> it = values; it.hasNext();) {
            // add the values in the arrayList
            dateList.add(((Text)it.next()).toString());
        }
        //----Modified section END--------------
        if(dateList.size()==1){ //If the mapper output has only one date , then select that date 
            // as the VALUE
            try  {
                date = formatter.parse(dateList.get(0).toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } //If part ends 
        else {
            String str = dateList.get(0).toString();
            try {

                date = formatter.parse(dateList.get(0).toString());
                //select the first date from list
            } catch (ParseException e1) {
                e1.printStackTrace();
            }

            for(int i=0 ; i <dateList.size();++i){
                try {
                    //compare the selected date with the rest of the dates in the list.
                    if((formatter.parse(dateList.get(i).toString())).compareTo(date)>0){
                        date=formatter.parse(dateList.get(i).toString());
                        // getting the max date from the list
                    }
                }
                catch (ParseException e) {
                    e.printStackTrace();
                }
            } //for loops ends
        }  // else part ends    

        Text value = new Text(date.toString());
        output.collect(key, value);
    }
}