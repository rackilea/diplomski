public static void main(String[] args) {
String option1 = "o1v1,o1v2,o1v3";
String option2 = "o2v1,o2v2,o2v3";
String option3 = "o3v1,o3v2,o3v3";
ArrayList<String> output = new ArrayList<String>();

String[] options1 = option1.split(",");
String[] options2 = option2.split(",");
String[] options3 = option3.split(",");

for(int i=0; i<options1.length; i++){
    StringBuilder sb = new StringBuilder();
    sb.append(options1[i]);
    sb.append(options2[i]);
    sb.append(options3[i]);
    output.add(sb.toString());


}

System.out.println(output);

}