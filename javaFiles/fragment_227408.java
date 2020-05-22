import java.util.stream.IntStream;

public class NodeStack {

public static int whoseTurn(int turnCount){
    return Integer.bitCount(turnCount) % 2;
}

public static void main(String[] args) {
    System.out.print("OEIS: ");
    IntStream.range(0,105).map(NodeStack::whoseTurn).forEach(i->System.out.print(i+", "));
    String result = IntStream.range(0,105).map(NodeStack::whoseTurn).collect(StringBuilder::new,(sb,i)->sb.append(i), StringBuilder::append).toString();
    System.out.println();
    IntStream.range(1,105).forEach(
            (i)-> System.out.println(i+"# "+result.substring(0,i)+ " : " +diff(result.substring(0,i)))
    );
}

public static int diff(String s){
    int zero = 0;
    int one = 0;
    for (char c:s.toCharArray()){
        if (c=='0')zero++;
        if (c=='1')one++;
    }
    return zero-one;
}

}