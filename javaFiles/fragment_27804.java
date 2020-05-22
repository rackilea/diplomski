public List<String> split(String source, char delimeter)
{
     List<String> result = new ArrayList<>();
     StringBuilder sb = new StringBuilder();
     for(int i = 0; i < source.length; i++)
     {
          if(source.charAt(i) == delimeter) 
          {
              result.add(sb.toString());
              sb.Clear();
          }
          else
          {
              sb.append(source.charAt(i));
          }
     }
     return result;
}