import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public class SomeBean {
private List<SomeObjects> data = new ArrayList<SomeObjects>();


public void addItem(){
data.add(new SomeObjects("someName"));
}


public List<SomeObjects> getData() {
    return data;
}


public void setData(List<SomeObjects> data) {
    this.data = data;
}

}