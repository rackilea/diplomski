Scanner scan = new Scanner(System.in) ;
String user ;
String [] empName , empPos ;
empName = new String [2] ;
empName [0] = "Sully" ;
empName [1] = "John" ;
empPos = new String [2] ;
empPos [0] = "Manager" ;
empPos [1] = "Employ" ;

System.out.println("Enter Your Name to know Your Position : ");
user = scan.nextLine()  ;

boolean unknown = true;

for (int i = 0 ; i <empName.length;i++ ) {
    //check if user input is equals
    if (empName[i].equals(user)) {
        unknown = false;
        System.out.printf("Hello %s you are %s !!\n",empName[i], empPos[i]);
        break;
    }
}

if (unknown)
    System.out.println("unknowing user !! ");