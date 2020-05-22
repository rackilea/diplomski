import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMinimumDifference {

static List<Integer> list1= new ArrayList<>();
static List<Integer> list2= new ArrayList<>();

public static void main(String[] args) {
    int[] arr= new int[]{3,-2,9,7};  
    // tested for these sample data:- [1,5,9,3] ; [4,3,5,9,11] ; 
//[7,5,11,2,13,15,14] ; [3,2,1,7,9,11,13] ; 
    //[3,1,0,5,6,9] ; [6,8,10,2,4,0] ; [3,1,5,7,0] ; [4,-1,5,-3,7] ; [3,-2,9,7]

    System.out.println("the minimum possible difference is: "+returnMinDiff(arr));
    System.out.println("the two resulting set of nos. are: "+list1+" and "+list2);
}

private static int  returnMinDiff(int[] array){
    int diff=-1;
    Arrays.sort(array);

    for(int a:array){
        int sumOfList1=0;
        int sumOfList2=0;

        for(Integer i:list1){
            sumOfList1+=i;
        }
        for(Integer i:list2){
            sumOfList2+=i;
        }
        if(sumOfList1<=sumOfList2){
        list1.add(a);
        }else{
            list2.add(a);
        }
    }

    List<Integer> list3=new ArrayList<>(list1);   
    List<Integer> list4= new ArrayList<>(list2); 
    if(list3.size()!=list4.size()){     // both list should contain equal no. of entries. 
        //If not, add 0 to the list having lesser no. of entries
        if(list3.size()<list4.size()){
            list3.add(0);
        }else{
            list4.add(0);
        }
    }
    Map<Integer, List<Integer>> mapOfProbables= new HashMap<Integer, List<Integer>>();
    int probableValueCount=0;
    for(int i=0; i<list3.size();i++){  
        for(int j=0; j<list4.size();j++){
            if(abs(list3.get(i)-list4.get(j))
   <abs(getSumOfEntries(list3)-getSumOfEntries(list4))){
                List<Integer> list= new ArrayList<>();
                list.add(list3.get(i));
                list.add(list4.get(j));    
                mapOfProbables.put(probableValueCount++, list);
            }
        }
    }
    int minimumDiff=abs(getSumOfEntries(list1)-getSumOfEntries(list2));
    List resultList= new ArrayList<>();
    for(List probableList:mapOfProbables.values()){ 
        list3=new ArrayList<>(list1);   
        list4= new ArrayList<>(list2);
        list3.remove(probableList.get(0));
        list4.remove(probableList.get(1));
        list3.add((Integer)probableList.get(1));
        list4.add((Integer)probableList.get(0));
        if(minimumDiff>abs(getSumOfEntries(list3)-getSumOfEntries(list4))){ // valid exchange 
                minimumDiff=abs(getSumOfEntries(list3)-getSumOfEntries(list4));
                resultList=probableList;
        }

    }

    if(resultList.size()>0){   // forming the two set of nos. whose difference of sum comes out to be minimum
        list1.remove(resultList.get(0));
        list2.remove(resultList.get(1));
        if(!resultList.get(1).equals(0) )   // (resultList.get(1).equals(0) && !list1.contains(0))
            list1.add((Integer)resultList.get(1));
        if(!resultList.get(0).equals(0) || (resultList.get(0).equals(0) && list2.contains(0)))
            list2.add((Integer)resultList.get(0));
    }

    return minimumDiff; // returning the minimum possible difference
}

private static int getSumOfEntries(List<Integer> list){
    int sum=0;
    for(Integer i:list){
        sum+=i;
    }
    return sum;
}
private static int abs(int i){
    if(i<=0) 
        i=-i;
    return i;
}
}