public class A {
  String [] month = new String[4];  

 public String[] select(int pick)
  {
        switch(pick)
     {
        case 1:
           month[0]="January";          
          break;
        case 2:
            month[0]="February";                
        break;
    case 3:
        month[0]="March";           
        break;
    case 4:             
        month[0]="April";   
        break;

    }
    return month;
}