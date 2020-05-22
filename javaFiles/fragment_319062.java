package AR;

class Node implements Comparable<Node> {
    public int frequency;
    public char value;

    public Node(int frequency, char value) {
        this.frequency = frequency;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        if (this.frequency > o.frequency) return 1;
        if (this.frequency < o.frequency) return -1;
        if (this.value > o.value) return 1;
        if (this.value < o.value) return -1;
        return 0;
    }
}

final class Sort<T extends Comparable<T>> {
    void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    int partition(T[] arr, int left, int right) {
        int i = left;
        T pivot = arr[left++];
        while (left <= right) {
            while (left <= right && arr[left].compareTo(pivot) <= 0) left++;
            while (left <= right && arr[right].compareTo(pivot) > 0) right--;
            if (left > right) break;
            swap(arr, left++, right--);
        }
        swap(arr, i, right);
        return right;
    }

    public void quickSort(T arr[], int left, int right) {
        if (left >= right) return;
        int i = partition(arr, left, right);
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

}

final class Main {
    public static void main(String[] args) {

        Node[] ns = new Node[]{new Node(10, 'a'), new Node(10, 'c'), new Node(8, 'a'), new Node(1, 'b'), new Node(10, 'a'), new Node(10, 'b'), new Node(8, 'a'), new Node(1, 'b'), new Node(10, 'a'), new Node(10, 'b'), new Node(8, 'a'), new Node(1, 'b'), new Node(0, 'z'), new Node(1, 'z')};
        int n = ns.length;
        Sort cl = new Sort();
        cl.quickSort(ns, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print("(" + ns[i].frequency + "," + ns[i].value + "), ");
            //(0,z), (1,b), (1,b), (1,b), (1,z), (8,a), (8,a), (8,a), (10,a), (10,a), (10,a), (10,b), (10,b), (10,c),
        }
    }
}