@Bean
public class RefData{
     public TreeMap<Object> treeMap;

     public TreeMap<Object> getData(){
         if(this.treeMap == null){  
            //read csv file & prepare TreeMap & store it in this.treeMap
         }
         return this.treeMap;
     }
}