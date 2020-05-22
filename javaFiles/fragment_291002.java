String[] cases = {"someSubString", "anotherSubString", "yetanotherSubString"};

int i;
for(i = 0; i < cases.length; i++)
    if(SomeString.contains(cases[i])) break;

switch(i) {
    case 0: //someSubString
        System.out.println("do something");
    break;
    case 1: //anotherSubString
        System.out.println("do something else");
    break;
    case 2: //yetanotherSubString
        System.out.println("do something even more different");
    break;
    default:
        System.out.println("do nothing");
}