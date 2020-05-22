StringBuilder toList = new StringBuilder();
for(i=0; i < cusEmail.length - 1; i++) {
    toList.append(cusEmail[i]);
    toList.append("; ");
    System.out.println(cusEmail[i]);
}
toList.append(cusEmail[i]);
System.out.println(toList.toString());