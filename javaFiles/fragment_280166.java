import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerConverter;
import org.dozer.Mapper;
import org.dozer.MapperAware;

public class TestConverter extends DozerConverter<String, List>
    implements MapperAware {

public TestConverter() {
    super(String.class, List.class);
    // TODO Auto-generated constructor stub
}


@Override
public void setMapper(Mapper mapper) {
    // TODO Auto-generated method stub

}

@Override
public List convertTo(String source, List destination) {
    if (source == null) {
         return new ArrayList<String>();
    }
    if (destination == null) {
         destination = new ArrayList<String>();
    }

    //destination.getAddressLine().add(source.getAdditionalStreetName());
    destination.add(source);
    return destination;
}



@Override
public String convertFrom(List source, String destination) {
    // TODO Auto-generated method stub
    return null;
}

}