String word = "omecodeexchangeuthercanbetreeofword";
    Set<String> set = new HashSet<>(Arrays.asList("abaco", "code", "exchange", "bold", "word", "can", "be", "tree", "folder", "and", "of", "leaf"));
    int n = word.length() + 1;
    int[] f = new int[n];
    int[] jChoices = new int[n];
    f[0] = 0;
    for (int i = 1; i < n; i++) {
        int best = Integer.MAX_VALUE;
        int bestJ = -1;
        for (int j = 0; j < i; j++) {
            int curr = f[j] + (set.contains(word.substring(j, i)) ? 0 : (i-j));
            if (curr < best) {
                best = curr;
                bestJ = j;
            }
        }
        jChoices[i] = bestJ;
        f[i] = best;
    }
    System.out.println("unmatched chars: " + f[n-1]);
    System.out.println("split:");
    int j = n-1;
    List<String> splits = new ArrayList<>();
    while (j > 0) { 
        splits.add(word.substring(jChoices[j],j));
        j = jChoices[j];
    }
    Collections.reverse(splits);
    for (String s : splits) System.out.println(s + " " + (set.contains(s)?"(match)":"(does not match)"));