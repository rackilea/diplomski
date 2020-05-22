public static boolean startsWith1(List<Long> list){
    //return list.stream().sorted().findFirst().get() == 1; //see @Holger's comment
    return Collections.min(list) == 1;
}
// The sum of all numbers from 1 to n = n * (n+1) /2; 
// you can use that to check if your list contains all numbers from 1 to n
public static boolean isConsecutive(List<Long> list){
    long n = list.size();
    return list.stream().mapToLong(Long::longValue).distinct().sum() == n * (n+1) /2;
}
public static void doSomething(List<Long> list) throws BadRequestException{
    if(!startsWith1(list)){   
        throw new BadRequestException("Sequence should start from 1 ");
    }
    if(!isConsecutive(list)) {
        throw new BadRequestException("Sequences should be in consecutive order");
    }
    else{
        // do whatever with your list
    }
}