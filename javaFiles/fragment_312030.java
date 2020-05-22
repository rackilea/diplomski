static void perm(char c0, int n0, char c1, int n1, String s, List<String> result) {
     if (n0 < 0 || n1 < 0)
         return;
     else if (n0 == 0 && n1 == 0)
         result.add(s);
     else {
         perm(c0, n0 - 1, c1, n1, s + c0, result);
         perm(c0, n0, c1, n1 - 1, s + c1, result);
     }

 }

 static List<String> perm(char c0, int n0, char c1, int n1) {
     List<String> result = new ArrayList<>();
     perm(c0, n0, c1, n1, "", result);
     return result;
 }

 public static void main(String[] args) {
     System.out.println(perm('A', 2, 'B', 2));
     // -> [AABB, ABAB, ABBA, BAAB, BABA, BBAA]
     System.out.println(perm('A', 8, 'B', 10).size());
     // -> 43758
 }