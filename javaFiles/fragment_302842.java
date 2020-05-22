while(D-->0){
    commonDivisor.clear();
    x = scan.nextInt();
    y = scan.nextInt();
    k = scan.nextInt();
    k = k - 1;

    commonDivisor = getCommonDivisor(x, y);
    Collections.reverse(commonDivisor);
    if (k >= commonDivisor.size()) {
       sb.append("\nNo candy today");
    } else if (k <= (commonDivisor.size() - 1)){
       sb.append(commonDivisor.get(k) + "\n");
    }
}
System.out.println(sb);