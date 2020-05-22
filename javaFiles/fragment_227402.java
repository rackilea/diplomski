num1=0;
num2=0;
num3=0;
for (int i=0;i<*number of times you need to repeat*;i++){
num1=yourXmlDoc.indexOf("humidity",num3);
num2=yourXmlDoc.indexOf("/humidity",num1);
num3=num2;
humidity[i]=yourXmlDoc.substring(num1+9,num2-1);
System.out.println(humidity[i]);

.. continue with more parameters to parse and let its starting point be num3
}