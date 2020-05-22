import java.util.Arrays;

    String element[] = null;
    while((element = reader.readNext()) != null){
        element = Arrays.copyOf(element, element.length + 1);
        element[element.length - 1] = "JSON";
        writer.writeNext(element);
    }