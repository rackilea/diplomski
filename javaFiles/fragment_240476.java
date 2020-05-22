BufferedReader br = new BufferedReader(new FileReader( "D:/log_2071-04-31.txt" ));
String strLine;
ArrayList<String> ans= new ArrayList<String>();

// Read rows
while ((strLine = br.readLine()) != null) {
    System.out.println(strLine);
    ans.add(strLine);
}

// Read again
for (String result: ans) {
    System.out.println(result);
}