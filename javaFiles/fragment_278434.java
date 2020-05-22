public class TestBench{
        public static void main(String[] args){
            int[] i = {1,2,3,4};
            System.out.println(scoresAverage(i));
       }

        public static double calculateAverage(int[] scores, int start, int end) {
            int count = 0;
            double score = 0.0;
            for (int i = start; i <= end; i++) {
                score += scores[i];
                count++;
            }
            score = (score / count);

            return score;
        }

        public static double scoresAverage(int[] scores) {
            int endOfFirstHalf = (scores.length / 2) - 1;
            double firstHalf = calculateAverage(scores, 0, endOfFirstHalf);
            double secondHalf = calculateAverage(scores, endOfFirstHalf + 1, scores.length - 1);

            if (firstHalf < secondHalf) {
                return secondHalf;
            } else {
                return firstHalf;
            }
        }
    }