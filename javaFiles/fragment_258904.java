public class staff {

//blabla
private static ArrayList<staff> st =new ArrayList<staff>();

public staff (String StaffID, String StaffPW) {
    //st = new ArrayList<staff>();
    this.StaffID = StaffID;
    this.StaffPW = StaffPW;
    //eventually:
    st.add(this);
}

public static void thestaff(){
    //blabla
}

//blabla

public static ArrayList<staff> getst() {
   return st;
}
}