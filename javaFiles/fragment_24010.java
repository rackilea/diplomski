import java.util.ArrayList;
import java.util.Random;

public class MergeTemplate {

    private Random random = new Random();

    private ArrayList<Comparable> temp1 = new ArrayList<>();
    private int num;


    public MergeTemplate() {
        this.num = 25;
    }

    public MergeTemplate(int num) {
        this.num = num;
    }

    public ArrayList<Comparable> fillArray() {
        ArrayList<Comparable> ar1 = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            ar1.add(random.nextInt(11));
        }
        screenOutput(ar1);
        return ar1;
    }

    public void screeOutput() {
        for (Comparable x : temp1) {
            System.out.println(x + " ");
        }
        System.out.println();
    }

    public void screenOutput(ArrayList<Comparable> temp) {
        for (Comparable x : temp) {
            System.out.println(x + " ");
        }
        System.out.println();
    }

    public void rMerge(ArrayList<Comparable> rList) {
        rMerge(rList, 0, rList.size() - 1);
    }

    public void rMerge(ArrayList<Comparable> rList, int first, int last) {

        int mid = 0;
        if (first >= last) {
            System.out.println("no error yet");
        } else {
            mid = (first + last) / 2;
            rMerge(rList, first, mid);
            rMerge(rList, mid + 1, last);
            merge(rList, first, mid, last);
        }
    }

    public void merge(ArrayList<Comparable> a, int first, int mid, int last) {
        int i, j, k, m;

        i = first;
        j = mid + 1;
        k = first;

        ArrayList<Comparable> tempList = new ArrayList<>();

        // compare two divided parts
        while (i <= mid && j <= last) {
            if (a.get(i).compareTo(a.get(j)) < 1) {
                tempList.add(a.get(i));
                i++;
            } else {
                tempList.add(a.get(j));
                j++;
            }
            k++;
        }

        if (i > mid) {
            for (m = j; m <= last; m++) {
                tempList.add(a.get(m));
                k++;
            }
        } else {
            for (m = i; m <= mid; m++) {
                tempList.add(a.get(m));
                k++;
            }
        }

        for (i = 0, j = first; i < tempList.size(); i++, j++) {
            a.set(j, tempList.get(i));
        }

    }

}