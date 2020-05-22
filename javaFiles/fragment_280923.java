public class MultiplicationTable {
private int maxNum;

public MultiplicationTable(int maxNum) {
    this.maxNum = maxNum;
}

public String createMultiplicationTable() {
    StringBuilder table = new StringBuilder();

    for(int i = 1; i<=maxNum;i++){
       for(int j = 1; j<=10; j++){                            
          table.append(i*j);
          table.append("\t"); 
       }
       table.append("\n");
    }

    return table.toString();
 }
}