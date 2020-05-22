public class ClassAverage{
    public static void main (String Args []){

        int sum = 0;
        int mark[] = new int [10];
        // The first iteration sums all elements
        for(int c = 0; c < 10; c++){
            System.out.print("Enter a mark: ");
            mark[c] = Keyboard.readInt();

            sum = sum + mark[c];
        }
        int average = sum / 10;
        // This iteration outputs elements that meet your requirements.
        for(int c = 0; c < 10; c++){
            if(mark[c]>=average){
                System.out.print(mark[c]);
            }
        }
    }
}