public class FindNearestInt
{
    public static void main(String[] args)
    {
        Random random = new Random();
        int array[] = new int[30];
        //Initialise array with rendom values
        for (int i = 0; i < array.length; i++)
        {
            array[i] = random.nextInt(200);
        }

        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        // Number you want to find in array
        int searchFor = 57;
        //Nearest lower you searching for  
        int nearestLower = 0;
        //Nearest upper you searching for 
        int nearestUpper = Integer.MAX_VALUE;
        int searchForExist = -1;
        for (int i = 0; i < array.length; i++)
        {
            int j = array[i];
            if (j < searchFor)
            {
                if(j > nearestLower){
                    nearestLower = j;
                }
            } else if (j > searchFor){
                if(j < nearestUpper){
                    nearestUpper = j;
                }
            } else {
                nearestLower = -1;
                nearestUpper = -1;
                searchForExist = j;
                break;
            }
        }
        System.out.println("Nearest Lower : " + nearestLower);
            // This will print -1 if number exist in array
        System.out.println("Provided Number Already Exist : " + searchForExist);
        System.out.println("Nearest Upper : " + nearestUpper);
    }
}