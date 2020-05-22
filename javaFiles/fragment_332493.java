package tester;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author 
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //generate 100 random items belonging to categories
       Random rand=new Random();
       List<Item> items=new ArrayList<>();
       int a=1,b=1,c=1,d=1,e=1;

       for (int i=0;i<100;i++){
          int randomNumber=rand.nextInt(5)+1;
          CATEGORY_TYPE categoryType=null;
          int num=0;
          switch (randomNumber) {
            case 1:
                categoryType=CATEGORY_TYPE.A;
                num=a++;
                break;

            case 2:
                categoryType=CATEGORY_TYPE.B;
                num=b++;
                break;

            case 3: 
                categoryType=CATEGORY_TYPE.C;
                num=c++;
                break;

            case 4: 
                categoryType=CATEGORY_TYPE.D;
                num=d++;
                break;

            case 5: 
                categoryType=CATEGORY_TYPE.E;
                num=e++;
                break;
          }

          String dummyData="Item "+categoryType.toString()+num;
          Item item=new Item(dummyData,categoryType); 
          items.add(item);
       }


       //arrange the items in lists by category 
       List<Item> categoryAItemsList=new ArrayList<>();
       List<Item> categoryBItemsList=new ArrayList<>();
       List<Item> categoryCItemsList=new ArrayList<>();
       List<Item> categoryDItemsList=new ArrayList<>();
       List<Item> categoryEItemsList=new ArrayList<>();
       for (Item item:items){
           if (item.getCategoryType()==CATEGORY_TYPE.A)
             categoryAItemsList.add(item);
           else if (item.getCategoryType()==CATEGORY_TYPE.B)
             categoryBItemsList.add(item);
           else if (item.getCategoryType()==CATEGORY_TYPE.C)
             categoryCItemsList.add(item);
           else if (item.getCategoryType()==CATEGORY_TYPE.D)
             categoryDItemsList.add(item);
           else if (item.getCategoryType()==CATEGORY_TYPE.E)
             categoryEItemsList.add(item);
       }


       //now we want to construct lists of possible groups of choosing from each category
       List<Item[]> subsetStoringListA=new ArrayList<>(); 
       List<Item[]> subsetStoringListB=new ArrayList<>(); 
       List<Item[]> subsetStoringListC=new ArrayList<>(); 
       List<Item[]> subsetStoringListD=new ArrayList<>(); 
       List<Item[]> subsetStoringListE=new ArrayList<>(); 


       processSubsets(categoryAItemsList.toArray(new Item[0]),2,subsetStoringListA); 
       processSubsets(categoryBItemsList.toArray(new Item[0]),2,subsetStoringListB);
       processSubsets(categoryCItemsList.toArray(new Item[0]),2,subsetStoringListC);
       processSubsets(categoryDItemsList.toArray(new Item[0]),2,subsetStoringListD);
       processSubsets(categoryEItemsList.toArray(new Item[0]),1,subsetStoringListE);

       System.out.println(" A groups number: "+subsetStoringListA.size());
       System.out.println(" B groups number: "+subsetStoringListB.size());
       System.out.println(" C groups number: "+subsetStoringListC.size());
       System.out.println(" D groups number: "+subsetStoringListD.size());
       System.out.println(" E groups number: "+subsetStoringListE.size());

       //now we just print all possible combinations of picking a single group from each list.
       //the group is an array with valid choices
//       for (Item[] subsetA:subsetStoringListA){
//         for (Item[] subsetB:subsetStoringListB){
//            for (Item[] subsetC:subsetStoringListC){
//                for (Item[] subsetD:subsetStoringListD){
//                    for (Item[] subsetE:subsetStoringListE){
//                        print(subsetA);
//                        print(subsetB);
//                        print(subsetC);
//                        print(subsetD);
//                        print(subsetE);
//                        System.out.println("\n");
//                    }
//                    
//                }
//            } 
//         }  
//       }


    }


    static void print(Item[] arr){
      for (Item item:arr)  
        System.out.print(item.getDumyData()+" "); 
    }

    static void processSubsets(Item[] set, int k,List<Item[]> subsetStoringList) {
    Item[] subset = new Item[k];
    processLargerSubsets(set, subset, 0, 0,subsetStoringList);
}

static void processLargerSubsets(Item[] set, Item[] subset, int subsetSize, int nextIndex,List<Item[]> subsetStoringList) {
    if (subsetSize == subset.length) { //here we have a subset we need to store a copy from it
        subsetStoringList.add(Arrays.copyOf(subset, subset.length));
    } else {
        for (int j = nextIndex; j < set.length; j++) {
            subset[subsetSize] = set[j];
            processLargerSubsets(set, subset, subsetSize + 1, j + 1,subsetStoringList);
        }
    }
}


    public static enum CATEGORY_TYPE {A,B,C,D,E} 

    private static class Item{
        private CATEGORY_TYPE categoryType;
        private String dumyData; 

        public Item(String dumyData,CATEGORY_TYPE categoryType) {
            this.dumyData = dumyData; //maybe bad name but i mean the object can have many other fields etc
            this.categoryType = categoryType;
        }

        /**
         * @return the categoryType
         */
        public CATEGORY_TYPE getCategoryType() {
            return categoryType;
        }

        /**
         * @return the dumyData
         */
        public String getDumyData() {
            return dumyData;
        }


    }



}