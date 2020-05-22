import java.util.ArrayList;
import java.util.List;

int size = 16;
int num = 4; // In your example either 4 or 2.
int rowLength = size / num;
List<Integer> sortedList = new ArrayList<Integer>();
for (int i=0;i<size / rowLength;++i) {
  int t = i;
  for (int j=0;j<rowLength / 2;++j) {
    sortedList.add(t+1);
    sortedList.add(t+(2*(num-i)));
    t += 2*num;
  }
}