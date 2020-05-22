import org.apache.commons.collections.list.LazyList;
import org.apache.commons.collections.FactoryUtils;



public class SubDevisonDto {

    private String devId;

    private List subDevisions = 
        LazyList.decorate(
          new ArrayList(),
          FactoryUtils.instantiateFactory(SubDivison.class));