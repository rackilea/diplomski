System.out.print("Add(A), Delete(D), Find(F), Size(S), Min(m), Max(M), List(L), Quit(Q) >> ");
char c = scan.next().charAt(0);
switch (c) {
    case 'A':
        int y = scan.nextInt(); // here you need next input
        bag.Add(y);
        break;
    case 'F':
        int y = scan.nextInt(); // here you need next input
        bag.Find(y);
        break;
    case 'S':
        bag.Size();
        break;
    case 'm':
        bag.Min();
        break;
    case 'M':
        bag.Max();
        break;
}