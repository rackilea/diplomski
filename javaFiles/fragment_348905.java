String result = "NO";
for (int i = 0; i < s.length(); i++) {

            if ((s.charAt(i) == 'l') && (s.charAt(i + 2) == 'l')) {

                result = "YES";

            }
}

System.out.println(result);