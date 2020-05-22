String votes = "ABBAB";

char[] StoringArray = votes.toCharArray();

int B = 0;
int A = 0;

for (int i = 0; i < StoringArray.length; i ++) {
if (StoringArray[i] == 'A') {
  A++;
} else if (StoringArray[i] == 'B') {
          B++;
          }

}

if (A == B) {
System.out.println("Tie");
} else if (A > B) {
System.out.println("A");
} else {
System.out.println("B");
}