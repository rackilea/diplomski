public class testString {
    public static void main(String[] args){

        //need to configure this accordingly            
        int row=3+1;
        int col=4+1;

        String[][] array=new String[row][col];
        //construct the string with the number of row-1
        String s1="testcaseZ : a,b,c";
        String s2="testcaseX : b,d";
        String s3="testcaseC : b";
        String[] strings=new String[]{s1,s2,s3};//strings should have lenghth of row-1
        String[] allValues=new String[]{"a","b","c","d"};

        //polulate the first row
        array[0][1]="a";
        array[0][2]="b";
        array[0][3]="c";
        array[0][4]="d";
        //Above, you can  dynamically construct the two arrays based on your input(say from files)

        for(int i=1;i<array.length;i++){//for every rest rows
            String text=strings[i-1];
            String theCase=text.substring(0,text.indexOf(":")).trim();//
            String valueText=text.replaceAll(theCase, "").replaceFirst(":", "").trim();         
            array[i][0]=theCase;

            String[] values=valueText.split(",");
            List valueList=Arrays.asList(values);

            for(int j=1;j<array[i].length;j++){//for every cols
                if(valueList.contains(allValues[j-1])){//if contains the value, 
                    array[i][j]="1";
                }
                else array[i][j]="0";
            }
        }

        //test the output           
        System.out.println(Arrays.deepToString(array));
    }
}