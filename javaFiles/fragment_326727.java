import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class BeanGenerator
{
    public static void main(String[] args) throws IOException
    {
        //testManualSetup();
        testAutomaticSetup();
    }

    private static void testManualSetup()
    {
        List<BeanProperty> beanProperties = 
            new ArrayList<BeanProperty>();
        beanProperties.add(new BeanProperty("name", String.class));
        beanProperties.add(new BeanProperty("age", Integer.TYPE));
        beanProperties.add(new BeanProperty("height", Double.TYPE));

        String result = generateBeanFile("Person", "", beanProperties);
        System.out.println(result);
    }

    private static void testAutomaticSetup() throws IOException
    {
        List<BeanProperty> beanProperties = inferBeanProperties("test.csv"); 

        System.out.println("Inferred properties:");
        for (BeanProperty beanProperty : beanProperties)
        {
            System.out.println(beanProperty);
        }

        String result = generateBeanFile("Person", "", beanProperties);
        System.out.println(result);
    }


    static List<BeanProperty> inferBeanProperties(String fileName) throws IOException
    {
        FileInputStream fileInputStream = null;
        try
        {
            fileInputStream = new FileInputStream(fileName);
            return inferBeanProperties(fileInputStream);
        }
        finally
        {
            if (fileInputStream != null)
            {
                fileInputStream.close();
            }
        }
    }


    private static List<BeanProperty> inferBeanProperties(
        InputStream inputStream) throws IOException
    {
        final String delimiter = ",";
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        List<String> names = null;
        List<Class<?>> types = null;
        while (true)
        {
            String line = br.readLine();
            if (line == null)
            {
                return Collections.emptyList();
            }
            if (line.trim().length()==0)
            {
                continue;
            }
            if (names == null)
            {
                names = tokenize(line, delimiter);
            }
            else
            {
                types = inferTypes(line, delimiter);
                break;
            }
        }
        List<BeanProperty> beanProperties = new ArrayList<BeanProperty>();
        for (int i=0; i<names.size(); i++)
        {
            String name = names.get(i);
            Class<?> type = types.get(i);
            BeanProperty beanProperty = new BeanProperty(name, type);
            beanProperties.add(beanProperty);
        }
        return beanProperties;
    }

    private static List<String> tokenize(String line, String delimiter)
    {
        List<String> list = new ArrayList<String>();
        String tokens[] = line.split(delimiter);
        for (String token : tokens)
        {
            list.add(token.trim());
        }
        return list;
    }
    private static List<Class<?>> inferTypes(String line, String delimiter)
    {
        List<String> tokens = tokenize(line, delimiter);
        List<Class<?>> types = new ArrayList<Class<?>>();
        for (String token : tokens)
        {
            types.add(inferType(token));
        }
        return types;
    }


    private static Class<?> inferType(String token)
    {
        try
        {
            Integer.parseInt(token);
            return Integer.TYPE;
        }
        catch (NumberFormatException e)
        {
            // Ignored
        }
        try
        {
            Double.parseDouble(token);
            return Double.TYPE;
        }
        catch (NumberFormatException e)
        {
            // Ignored
        }
        return String.class;
    }


    static class BeanProperty
    {
        private final String name;
        private final Class<?> type;

        BeanProperty(String name, Class<?> type)
        {
            this.name = name;
            this.type = type;
        }

        String getName()
        {
            return name;
        }

        Class<?> getType()
        {
            return type;
        }

        @Override
        public String toString()
        {
            return name+": "+type;
        }
    }

    static String generateBeanFile(String beanName,
        String header, 
        List<BeanProperty> beanProperties)
    {
        StringBuilder sb = new StringBuilder();

        sb.append(header);

        sb.append("public class "+beanName+"\n");
        sb.append("{"+"\n");
        for (BeanProperty beanProperty : beanProperties)
        {
            sb.append("    private ");
            sb.append(beanProperty.getType().getSimpleName());
            sb.append(" ");
            sb.append(decapitalize(beanProperty.getName()));
            sb.append(";"+"\n");
        }
        sb.append("\n");
        sb.append("    public "+beanName+"()"+"\n");
        sb.append("    {"+"\n");
        sb.append("        // Default constructor"+"\n");
        sb.append("    }"+"\n");
        for (BeanProperty beanProperty : beanProperties)
        {
            sb.append("\n");
            sb.append(createSetterString(beanProperty));
            sb.append("\n");
            sb.append(createGetterString(beanProperty));
        }
        sb.append("}"+"\n");
        return sb.toString();
    }

    private static String createSetterString(BeanProperty beanProperty)
    {
        StringBuilder sb = new StringBuilder();

        sb.append("    public void set");
        sb.append(capitalize(beanProperty.getName()));
        sb.append("(");
        sb.append(beanProperty.getType().getSimpleName());
        sb.append(" ");
        sb.append(decapitalize(beanProperty.getName()));
        sb.append(")"+"\n");

        sb.append("    {"+"\n");

        sb.append("        this.");
        sb.append(decapitalize(beanProperty.getName()));
        sb.append(" = ");
        sb.append(decapitalize(beanProperty.getName()));
        sb.append(";"+"\n");

        sb.append("    }"+"\n");

        return sb.toString();
    }

    private static String createGetterString(BeanProperty beanProperty)
    {
        StringBuilder sb = new StringBuilder();

        sb.append("    public ");
        sb.append(beanProperty.getType().getSimpleName());
        sb.append(" get");
        sb.append(capitalize(beanProperty.getName()));
        sb.append("()"+"\n");

        sb.append("    {"+"\n");

        sb.append("        return ");
        sb.append(decapitalize(beanProperty.getName()));
        sb.append(";"+"\n");

        sb.append("    }"+"\n");

        return sb.toString();
    }

    private static String decapitalize(String s)
    {
        char c = Character.toLowerCase(s.charAt(0));
        return c + s.substring(1);
    }

    private static String capitalize(String s)
    {
        char c = Character.toUpperCase(s.charAt(0));
        return c + s.substring(1);
    }

}