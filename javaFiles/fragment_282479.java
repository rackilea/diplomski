import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String[] args) throws Exception {
    List<HashMap<String, String>> result = new ArrayList<>();

    HashMap<String, String> dados = new HashMap<>();

    dados.put("sigla", "TST");
    dados.put("nome", "Teste");
    result.add(dados);

    List<Posto> dadosProcessados = convertDados(Posto.class, result);

    for (Posto posto : dadosProcessados) {
      System.out.println(posto.getSigla() + " => " + posto.getNome());
    }

  }


  public static <T> List<T> convertDados(Class<T> entity, List<HashMap<String, String>> dados) throws NoSuchMethodException,
      SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
    Field[] fields = entity.getDeclaredFields();
    Method[] allSetterMethods = entity.getMethods();
    Map<Integer, Method> setters = new HashMap<>();
    Class<?>[] paramTypes = new Class<?>[fields.length];
    List<T> result = new ArrayList<>();
    int cont = 0;

    for (Method method : allSetterMethods) {
      if (method.getName().startsWith("set")) {
        paramTypes[cont] = method.getParameterTypes()[0];
        setters.put(cont, method);
        cont++;
      }
    }

    for (Field field : fields) {
      for (Map.Entry<String, String> dado : dados.get(0).entrySet()) {
        if (dado.getValue() != null && field.getName().equalsIgnoreCase(dado.getKey())) {
          for (Map.Entry<Integer, Method> set : setters.entrySet()) {
            if (set.getValue().getName().substring(3).equalsIgnoreCase(field.getName())) {
              Method method = entity.getMethod(set.getValue().getName(), paramTypes[set.getKey()]);
              T obj = entity.getConstructor().newInstance();
              method.invoke(obj, dado.getValue());
              result.add(obj);
              break;
            }
          }
        }
      }
    }

    return result;
  }
}