public static List<String> validOptions = Arrays.asList("1000","1100","1110","1111");

public boolean isValid(Integer a, Integer b, Integer c, Integer d)
{
    StringBuilder sb = new StringBuilder();
    sb.append(a==null ? 0 : 1); 
    sb.append(b==null ? 0 : 1), 
    sb.append(c==null ? 0 : 1); 
    sb.append(d==null ? 0 : 1);
    return validOptions.contains(sb.toString());
}