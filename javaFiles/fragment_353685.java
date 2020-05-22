final String url  = "www.domain.com/I-Need-This-Part";
final int neededStart = url.indexOf('/')+1;
char mostFrequent = '\u0000';
int highestFreq = 0;
for (char delim : new char[] {'%', '-', '$', '+'}) {
  int cnt = 0;
  for (int i = url.indexOf(delim, neededStart); i != -1;
        i = url.indexOf(delim, i+1), cnt++);
  if (cnt > highestFreq) { highestFreq = cnt; mostFrequent = delim; }
}
System.out.println(mostFrequent);