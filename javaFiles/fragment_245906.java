package misc;

import java.util.*;

/**
 * PageSumProbability
 *
 * @author Michael
 * @since 10/14/11
 */
public class PageSumProbability {

    private Map<Integer, Integer> pageNumberSum;
    private Map<Integer, List<Integer>> sumPageNumbers;

    public static void main(String[] args) {
        if (args.length > 1) {
            int maxPageNumber = Integer.valueOf(args[0]);            
            int randomSum = Integer.valueOf(args[1]);
            PageSumProbability psp = new PageSumProbability(maxPageNumber);
            System.out.println(psp.getPageNumberSum());
            System.out.println(psp.getSumPageNumbers());
            System.out.printf("random sum: %d probability of opening page # that equals random sum: %5.3f%%\n",
                    randomSum, 100*psp.getProbabilityOfSum(randomSum));
        } else {
            System.out.print("Usage: PageProbabilitySum <# pages> <random sum>");
        }
    }

    public PageSumProbability(int maxPageNumber) {
        this.pageNumberSum = new TreeMap<Integer, Integer>();
        this.sumPageNumbers = new TreeMap<Integer, List<Integer>>();

        for (int i = 1; i <= maxPageNumber; ++i) {
            int sum = this.calculateSumOfDigits(i);
            this.pageNumberSum.put(i, sum);
            List<Integer> pages = this.sumPageNumbers.get(sum);
            if (pages == null) {
                pages = new LinkedList<Integer>();
            }
            pages.add(i);
            this.sumPageNumbers.put(sum, pages);
        }
    }

    public static int calculateSumOfDigits(int pageNumber) {
        int sum = 0;
        String pageNumberAsString = String.valueOf(Math.abs(pageNumber));
        for (int i = 0; i < pageNumberAsString.length(); ++i) {
            StringBuilder digit = new StringBuilder();
            digit.append(pageNumberAsString.charAt(i));
            sum += Integer.valueOf(digit.toString());
        }

        return sum;
    }

    public double getProbabilityOfSum(int randomSum) {
        if (randomSum <= 0)
            throw new IllegalArgumentException("random sum must be greater than zero");
        double probability = 0.0;
        List<Integer> pages = this.sumPageNumbers.get(randomSum);
        if (pages != null) {
            probability = (double) pages.size()/this.pageNumberSum.size();
        }

        return probability;
    }

    public Map<Integer, Integer> getPageNumberSum() {
        return Collections.unmodifiableMap(this.pageNumberSum);
    }

    public Map<Integer, List<Integer>> getSumPageNumbers() {
        return Collections.unmodifiableMap(this.sumPageNumbers);
    }
}