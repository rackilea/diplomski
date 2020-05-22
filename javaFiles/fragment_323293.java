for (Member member : memberList){
    if (inputName.equals(member.getName())) {    
        member.setFeePaid("yes");
        System.out.println();
        System.out.println(member.getName() +" has paid their membership fee.\n");
        System.out.println("********Returning to Main Menu.********\n");   
        break;             
    }
}