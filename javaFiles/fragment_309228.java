//Java program to print next 
//greater element using stack 

import java.util.ArrayList;
import java.util.Collections;

public class NGE
{
    static class stack
    {
        int top;
        int items[] = new int[100];

        // Stack functions to be used by printNGE
        void push(int x)
        {
            if (top == 99)
            {
                System.out.println("Stack full");
            }
            else
            {
                items[++top] = x;
            }
        }

        int pop()
        {
            if (top == -1)
            {
                System.out.println("Underflow error");
                return -1;
            }
            else
            {
                int element = items[top];
                top--;
                return element;
            }
        }

        boolean isEmpty()
        {
            return (top == -1) ? true : false;
        }
    }

    /* prints element and NGE pair for
    all elements of arr[] of size n */
    static void printNGE(int arr[], int n)
    {
        int i = 0;
        stack s = new stack();
        s.top = -1;
        int element, next;

        //answer initialized with zeros
        ArrayList<Integer> answer = new ArrayList<>(Collections.nCopies(n, 0));

        /* push the first element to stack */
        s.push(0);

        // iterate for rest of the elements
        for (i = 1; i < n; i++)
        {
            next = i;

            if (s.isEmpty() == false)
            {

                // if stack is not empty, then
                // pop an element from stack
                element = s.pop();

                /* If the popped element is smaller than 
                next, then a) print the pair b) keep 
                popping while elements are smaller and 
                stack is not empty */
                while (arr[element] < arr[next])
                {
                    answer.set(element, next - element);
                    if (s.isEmpty() == true)
                        break;
                    element = s.pop();
                }

                /* If element is greater than next, then 
                push the element back */
                if (arr[element] > arr[next])
                    s.push(element);
            }

            /* push next to stack so that we can find next 
            greater for it */
            s.push(next);
        }

        System.out.println(answer);
    }

    public static void main(String[] args)
    {
        int arr[] = { 70, 71, 74, 69, 70, 76, 71, 80, 70, 65 };
        int n = arr.length;
        printNGE(arr, n);
    }
}