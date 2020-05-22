public class Answer {

public static void main(String[] args) throws Exception {
    List<String> eachLineList = new ArrayList<String>();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String b = br.readLine();
    eachLineList.add(b.trim()); //Line 1 added to String list

    b = br.readLine();
    eachLineList.add(b.trim()); //Line 2 added to String list

    b = br.readLine();
    eachLineList.add(b.trim()); //List 3 added to String list

    String[] numbers;
    for (String line : eachLineList) {
        numbers = line.split("\\s+");
        if (numbers.length <= 1) {
            //means if there was one or less integer each line don't do anything
            break;
        } else {
            int intNum;
            int temp = 0;
            for (String num : numbers) {
                intNum = Integer.parseInt(num);
                temp += intNum;
            }
            System.out.println(temp);
        }
    }
}}