public interface MonthValue { //class or interface, I just didn't want to type out the simple implementation
   String getMonth();
   double getDouble();
}

//set2014 now needs to contain MonthValues
MonthValue max = set2014[0];

for(int i = 1; i < set2014.length; i++){
    MonthValue current = set2014[i];
    if(current.getValue() > max.getValue()){
        max = current;
    }
}

System.out.println("Largest figure is " + max.getValue());
System.out.println("In month " + max.getMonth());