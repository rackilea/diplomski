static String findNumber(List<Integer> arr, int k) {
            String res = "YES";
            for (int i = 0; i < arr.size(); i++) {
                if (k == arr.get(i))
                    res = "YES";
                    break;
                else
                    res = "NO";

            }

            return res;

        }