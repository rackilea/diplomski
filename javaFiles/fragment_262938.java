BufferedReader br = new BufferedReader(new FileReader("<your-text-file>"));
String txtNum;
while((txtNum = br.readLine()) != null)
{
   //txtNum is the number read, use it however you need
   if (txtNum.length() > 8) {
      thisMethod(txtNum.substring(0, 8));
   }
}