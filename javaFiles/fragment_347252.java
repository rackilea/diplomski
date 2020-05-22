// Class level member declaration
ArrayList<Integer> ValList = new ArrayList<Integer>();

public void Rand(){
          Random rand = new Random();
          int Val = rand.nextInt(5); 

          ValList.add(Val);
          Log.d("LOOK", ValList.toString()); 
          // Also here you are printing size of Arraylist not a content of arraylest
          Log.i("VALUE LIST ", ValList.size()+" <<<<LIST HERE"); 
 }