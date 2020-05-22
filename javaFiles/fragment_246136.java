public class MainClass {
    public static void main(String[] args) {
        Map<String, BigDecimal> aMap=new HashMap<>();

        aMap.put("A",new BigDecimal(12));
        aMap.put("B",new BigDecimal(23));
        aMap.put("C",new BigDecimal(67));
        aMap.put("D",new BigDecimal(99));
         Map<String, Long> o =  aMap.entrySet().stream().collect(Collectors.groupingBy( a ->{
             //Do the logic here to return the group by function
             if(a.getValue().compareTo(new BigDecimal(0))>0 &&
                     a.getValue().compareTo(new BigDecimal(25))<0)
                 return "0-25";

             if(a.getValue().compareTo(new BigDecimal(26))>0 &&
                     a.getValue().compareTo(new BigDecimal(50))<0)
                 return "26-50";

             if(a.getValue().compareTo(new BigDecimal(51))>0 &&
                     a.getValue().compareTo(new BigDecimal(75))<0)
                 return "51-75";
             if(a.getValue().compareTo(new BigDecimal(76))>0 &&
                     a.getValue().compareTo(new BigDecimal(100))<0)
                 return "76-100";

             return "not-found";
         }, Collectors.counting()));

         System.out.print("Result="+o);


    }

}