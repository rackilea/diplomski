public class numberSwapsReview{
        public static void main(String [] args)
        { 
            // define an Integer array of 1000 elements
            Integer[] bubbleArray = new Integer[1000];

            // load the array with random numbers using
            // a for loop and Math.random() method - (int)(Math.random()*1000)
            for (int i = 0; i < bubbleArray.length; i++) {
                bubbleArray[i] = (int)(Math.random() * 1000);
            }

            SearchSortAlgorithms<Integer> sortObject = new SearchSortAlgorithms<Integer>();

            sortObject.bubbleSort(bubbleArray, 1000);
            sortObject.getBubbleSwaps();
        }
    }