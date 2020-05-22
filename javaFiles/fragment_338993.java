String inputFromDatabase = "1,5";
String[] p = inputFromDatabase.trim().split(",");
int[] ans = new int[p.length];
for (int a = 0; a < p.length; a++) {
    ans[a] = Integer.parseInt(p[a]);
}
table.setWidths(ans);