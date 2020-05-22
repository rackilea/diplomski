public static void main(String[] args)
{
    String[] football_club = { "Barcelona", "Real Madrid", "Chelsea", "Real Madrid", "Barcelona", "Barcelona" };
    boolean[] seen = new boolean[football_club.length];
    String result_club = null;
    int result_count = 0;
    for (int i = 0; i < football_club.length; i++) {
        if (!seen[i]) {
            seen[i] = true;
            int count = 1;
            for (int j = i + 1; j < football_club.length; j++) {
                if (!seen[j]) {
                    if (football_club[i].equals(football_club[j])) {
                        seen[j] = true;
                        count++;
                    }
                }
            }
            if (count > result_count) {
                result_count = count;
                result_club = football_club[i];
            }
        }
    }
    System.out.println(result_club);
}