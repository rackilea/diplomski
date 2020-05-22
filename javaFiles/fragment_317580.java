public String mil(String temp){
    Time_display object2=new Time_display();
    // This value is not null...
    object2.Display(temp);
    return String.format ("%02d:%02d:%02d", hour, minute, second);
}