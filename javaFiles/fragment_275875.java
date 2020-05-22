@Controller
public class MyController {
    @ResponseBody
    @JsonView(View.MyView.class)
    public DyntableResponse<CustomEntity> getEntities() {
       final DyntableResponse<CustomEntity> resp = new DyntableResponse<>();
       resp.setRecords(...); // Your finder here.
       return resp;
    }
}