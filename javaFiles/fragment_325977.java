String parsedText = pdfStripper.getText(pdDoc);
System.out.println(parsedText);
FileWriter out = new FileWriter("output.txt"); 
out.append(parsedText);
out.close();

//no need for this code, it reads input from user (using keyboard)
 /*
 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
 String line = in.readLine();
 while (line!= null) {

         out.append(line);
         out.append("\n");
       }
out.close();
*/