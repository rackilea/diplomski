@Test
public void testReplaceBlanks(){
char input = 0;
char escape = '\u0000';

for(char i = 0; i <= 65535; ++i){
    input = (char) (escape + i);
    System.out.print(input);
    System.out.print(" ");
    if( i % 80 == 0){
        System.out.println();
    }

    String test = new String(Character.toString(input));
    assertTrue(!"".equals(test.replaceAll("", "")));

    if(i == 65535)
        break;
}
}