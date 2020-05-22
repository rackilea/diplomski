class Main {
public static void main(String[] args) {
        System.out.println("Please input a string:");
        Scanner input = new Scanner(System.in);
        String s1 = input.nextLine();
        String s2 = input.nextLine();
        String s3 = input.nextLine();
        int i1 = sumLetter(s1);
        int i2 = sumLetter(s2);
        int i3 = sumLetter(s3);
        StringWithUppercaseSize[] sizes = { new StringWithUppercaseSize(s1, i1), new StringWithUppercaseSize(s2, i2), new StringWithUppercaseSize(s3, i3) };
        Arrays.sort(sizes, Comparator.comparing(StringWithUppercaseSize::getUppercaseLength));
        System.out.println(sizes[0].string + " has a minimum number of uppercase: "+ sizes[0].uppercaseLength);
        System.out.println(sizes[2].string + " has a maximum number of uppercase: "+ sizes[2].uppercaseLength);
    }
    public static int sumLetter(String m) {
        int count = 0;
        for(int i = 0; i < m.length();i++) {
            if(Character.isUpperCase(m.charAt(i)))
                count++;
        }
        return count;
    }
}