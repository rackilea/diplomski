public static void payMemberYearlyFees(){
    System.out.println("Enter the name of the member who has to pay their fee:");
    String inputName = input.nextLine();

    for (int i=0; i < memberCount; i++) {       
        Member member = memberList[i];            

        if (inputName.equals(member.getName())) {    
            member.setFeePaid("yes");
            System.out.println();
            System.out.println(member.getName() +" has paid their membership fee.\n");
            System.out.println("********Returning to Main Menu.********\n");   
            break;             
        }
    }   
}