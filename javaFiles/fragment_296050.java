import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class SolutionStack {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
         Stack st = new Stack();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            int ch = sc.nextInt();
            stackMethod(st,ch);
        }

    }

    private static void stackMethod(Stack st, int ch ) {
        // TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);
        st.size();
        System.out.println(st.size());
        switch(ch){
        case 1: 
            int num = sc.nextInt();
            st.push(num);
            break;
        case 2: 
            st.pop();
            break;
        case 3 : 
            Iterator<Integer> iterator = st.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }

    }
}