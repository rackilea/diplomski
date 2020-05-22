public class Reduce extends Reducer<Text, Text, Text, Text> {
HashMap<Text, Integer>input = new HashMap<Text, Integer>();

public void reduce(Text key, Iterable<Text> values , Context context)
throws IOException, InterruptedException {
    int sum = 0;
    for(Text val: values){
        String word = val.toString(); -- processing each row
        String[] wordarray = word.split(' ');
        for(int i=0 ; i<wordarray.length; i++)
       {
        if(input.get(wordarray[i]) == null){
        input.put(wordarray[i],1);}
        else{
         int value =input.get(wordarray[i]) +1 ; 
         input.put(wordarray[i],value);
         }
       }     

   context.write(new Text(key), new Text(input.toString()));
}