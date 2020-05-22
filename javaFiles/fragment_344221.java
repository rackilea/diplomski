void continueTree(ArrayList<int> numbers)
{
    if (numbers.count() == 0) return;
    this.left = new Node(numbers.get(0));
    numbers.remove(0);
    if (numbers.count() == 0) return;
    this.right = new Node(numbers.get(0));
    numbers.remove(0);
    this.left.continueTree(numbers);
    this.right.continueTree(numbers);
}