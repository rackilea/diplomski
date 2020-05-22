public static void main (String[] args) throws java.lang.Exception
{
    int value = 877115755;

    String number = String.valueOf(value);

    int[] arr = new int[number.length()];

    int length = (int) (Math.log10(value) + 1);
    for (int i = 0; i < length; i++) {
        arr[i] = number.charAt(i) - '0';
    }
    int var = arr[0];
    int index = 0;
    int startIndex = 0;
    boolean changed = false;

    while(startIndex<arr.length-1){
        var = arr[startIndex];
        for (int i = startIndex+1; i < arr.length; i++) {
            int temp = arr[i];
            if (temp > var) {
                var = temp;
                index = i;
                changed = true;
                System.out.println("Larg Val "+arr[i]);
            }
        }
        if(changed)
            break;
        startIndex++;
    }

    //this is the swap part
    int tmp = arr[index];
    arr[index] = arr[startIndex];
    arr[startIndex] = tmp;  

    for (int j = 0; j < arr.length; j++) {
        System.out.println("Values in arry are " + arr[j]);
    }
}