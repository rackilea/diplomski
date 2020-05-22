public class MyController extends Controller {


  public static void index(){
    Map xyz = ....;

    helperMethod(xyz);

  } 

  @Util
  public static void helperMethod(Map map){
    /// do stuff
  } 

}