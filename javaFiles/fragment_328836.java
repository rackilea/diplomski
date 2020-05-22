void convert(String str)
{
    int i = 0;
    switch (str.charAt(0)) {
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
        case '0':
            i = Integer.parseInt(str);
            break;
        default:
            System.out.println ("Should start with fixnumber");
    }
    System.out.println (i);
}