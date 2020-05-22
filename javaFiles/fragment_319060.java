package AR;

class Node {
    public int frequency;
    public char value;
    public Node(int frequency, char value) {
        this.frequency = frequency;
        this.value = value;
    }
}
final class Main {
    static int partition(Node[] arr, int left, int right) {
        int i = left+1, j = right;
        Node tmp;
        int pivot =  left  ;
        while (i <= j) {
            while (i <= j && (arr[i].frequency < arr[pivot].frequency || (arr[i].frequency == arr[pivot].frequency && arr[i].value <= arr[pivot].value)))
                i++;
            while (i <= j && (arr[j].frequency > arr[pivot].frequency || (arr[j].frequency == arr[pivot].frequency && arr[j].value > arr[pivot].value)))
                j--;
            if (i > j) break;
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        tmp = arr[pivot];
        arr[pivot] = arr[j];
        arr[j] = tmp;
        return j;
    }
    public static void quickSort(Node arr[], int left, int right) {
        if (left >= right) return;
        int i = partition(arr, left, right);
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }
    public static void main(String[] args) {
        Node[] ns = new Node[]{new Node(10, 'a'), new Node(10, 'b'), new Node(8, 'a'), new Node(1, 'b'), new Node(10, 'a'), new Node(10, 'b'), new Node(0, 'z'), new Node(8, 'a'), new Node(1, 'b'), new Node(10, 'a'), new Node(10, 'b'), new Node(8, 'a'), new Node(1, 'b'), new Node(1, 'z')};
        int n = ns.length;
        quickSort(ns, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print("(" + ns[i].frequency + "," + ns[i].value + "), ");
            //(0,z), (1,b), (1,b), (1,b), (1,z), (8,a), (8,a), (8,a), (10,a), (10,a), (10,a), (10,b), (10,b), (10,b),
        }
    }
}