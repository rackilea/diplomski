public interface Rule<T> {
  String execute(T dataProvider) // *** missing semicolon
}


public interface DataProvider {

}

public class RulesExecutor() { // *** class declarations have no parenthesis