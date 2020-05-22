package AR;

class Node {
    public int frequency;
    public char value;

    public Node(int frequency, char value) {
        this.frequency = frequency;
        this.value = value;
    }
}

final class Sort {

    int partition(Node arr[], int left, int right) {
        int i = left, j = right;
        Node tmp;
        Node pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (i <= j && (arr[i].frequency < pivot.frequency || (arr[i].frequency == pivot.frequency && arr[i].value < pivot.value)))
                i++;
            while (i <= j && (arr[j].frequency > pivot.frequency || (arr[j].frequency == pivot.frequency && arr[j].value > pivot.value)))
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }

    public void quickSort(Node arr[], int left, int right) {
        if (left > right) return;
        int index = partition(arr, left, right);
        if (left < index - 1)
            quickSort(arr, left, index - 1);
        if (index < right)
            quickSort(arr, index, right);
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