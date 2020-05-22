public class EvaluationPreFix {

    public static void main(String[] args) {
        //1. parameterized with String
        Stack<String> st = new Stack();
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the size of expression");
        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < t; i++) {
            System.out.println("enter an element");
            String element = sc.nextLine();
            st.push(element);
        }

        int r = EvaluationPrefix(st); //marks an Error here
        System.out.println("Result: " + r);

    }

    //2. parameterized with String
    public static int EvaluationPrefix(Stack<String> st) {
        //3. parameterized with Integer
        Stack<Integer> st2 = new Stack();

        while (!st.isEmpty()) {
            String e = st.pop();
            //4. arithmetic sign comparison to string instead 
            //of character
            if (e.equals("+")) {
                st2.push(st2.pop() + st2.pop());
            } else if (e.equals("-")) {
               st2.push(st2.pop() - st2.pop());
            } else if (e.equals("*")) {
               st2.push(st2.pop() * st2.pop());
            } else if (e.equals("/")) {
               st2.push(st2.pop() / st2.pop());
            } else {
               st2.push(Integer.valueOf(e));
            }
        }

        return st2.pop();
    }

}