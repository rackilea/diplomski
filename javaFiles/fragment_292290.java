BufferedReader in1 = new BufferedReader(new FileReader("purchaseData.txt")); 
String line1; 
line1 = in1.readLine();
while (line1 != null )
{
    String[] field1 = line.split(",");
    int cardInt; 
    int receiptId;
    receiptId = Integer.parseInt(field1[0]); 
    cards cards3;
    cardInt = Integer.parseInt(field1[1]);
    cards3 = map.get(cardInt);
    purchase p2 = new purchase(Integer.parseInt(field1[0]), map.get(cardInt), Double.parseDouble(field1[2]), Double.parseDouble(field1[3]), Double.parseDouble(field1[4]), Double.parseDouble(field1[5]), Double.parseDouble(field1[6]));
    purchaseMap.put(receiptId, cards3);
}