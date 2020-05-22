private static Method[] methods ;

 public static void main(String[] args){
    try{
        Class ball = Class.forName("sport.soccer.Ball"); 
        methods = ball.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            methods[i].setAccessible(true);
        }
        sport.soccer.Ball.main(new String[]{}); 
    }
    catch(Exception e){
        e.printStackTrace();
    }
  }