//Will return dividers of x, not x/2
public static int[] findDividers(int x) { //not int[] x
//if x is of type int[] i.e an array, it makes no sense to
//use the '/' and '%' operators on it. That's why the compiler was
//complaining on your code

int[] array = new int[x/2];
for(int i=1; i <= array.length; i++) {
    // int c = x/i;
    if (x%i == 0) {
        array[i-1] = i;   
        System.out.println(i);

    }

}
return array;
}