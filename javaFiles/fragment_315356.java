private String[] options;

public void initOptions(int num)
{
    String newOptions = new String[num];
    for(int i=0; i<Math.min(num, options.length); ++i ) {
      newOptions[i] = options[i];
    }
    options = newOptions;
}