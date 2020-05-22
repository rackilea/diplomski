public class NavigationComponent {

private GameScreen gameScreen;

public NavigationComponent(){
      gameScreen = new GameScreen(){
           @override
          public paintComponent(Graphics g){
              // code here
          }

      };
}

}