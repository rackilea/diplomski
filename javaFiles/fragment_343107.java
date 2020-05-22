public class MainActivity extends AppCompatActivity {

String data = "[{\"project_id\":1,\"date\":\"Undefined\",\"project_code\":\"ea60f6190c\",\"title\":\"test\",\"description\":\"test\",\"demo_url\":null,\"project_category_id\":null,\"client_id\":null,\"company_id\":null,\"staffs\":\"4,5,\",\"budget\":0,\"timer_status\":0,\"timer_starting_timestamp\":null,\"total_time_spent\":0,\"progress_status\":null,\"timestamp_start\":\"1516874400\",\"timestamp_end\":\"1516878000\",\"project_status\":1,\"project_note\":null,\"institution_id\":12,\"project_state\":2,\"strata_manager\":6,\"site_contact\":7,\"place_of_service\":18},{\"project_id\":2,\"date\":\"27\\/01\\/2018\",\"project_code\":\"b9197f9e0c\",\"title\":\"test 2\",\"description\":\"test 2\",\"demo_url\":null,\"project_category_id\":null,\"client_id\":null,\"company_id\":null,\"staffs\":\"4,5,\",\"budget\":0,\"timer_status\":0,\"timer_starting_timestamp\":null,\"total_time_spent\":0,\"progress_status\":null,\"timestamp_start\":\"1515484800\",\"timestamp_end\":\"1515502800\",\"project_status\":1,\"project_note\":null,\"institution_id\":12,\"project_state\":0,\"strata_manager\":6,\"site_contact\":6,\"place_of_service\":18},{\"project_id\":3,\"date\":\"Undefined\",\"project_code\":\"1ed0450f71\",\"title\":\"Sit quo sint necessitatibus\",\"description\":\"Quia obcaecati nihil sit quo sint necessitatibus enim ut dicta in\",\"demo_url\":null,\"project_category_id\":null,\"client_id\":null,\"company_id\":null,\"staffs\":\"\",\"budget\":0,\"timer_status\":0,\"timer_starting_timestamp\":null,\"total_time_spent\":0,\"progress_status\":null,\"timestamp_start\":null,\"timestamp_end\":null,\"project_status\":0,\"project_note\":null,\"institution_id\":12,\"project_state\":2,\"strata_manager\":5,\"site_contact\":6,\"place_of_service\":18},{\"project_id\":4,\"date\":null,\"project_code\":\"49f120bade\",\"title\":\"xczxc\",\"description\":\"zcxzcxzcxz\",\"demo_url\":null,\"project_category_id\":null,\"client_id\":null,\"company_id\":null,\"staffs\":\"\",\"budget\":0,\"timer_status\":0,\"timer_starting_timestamp\":null,\"total_time_spent\":0,\"progress_status\":null,\"timestamp_start\":null,\"timestamp_end\":null,\"project_status\":1,\"project_note\":null,\"institution_id\":12,\"project_state\":1,\"strata_manager\":5,\"site_contact\":8,\"place_of_service\":18},{\"project_id\":5,\"date\":null,\"project_code\":\"d8d68134ee\",\"title\":\"Freshwater, 65 Oliver Street, Build New House SP00001 QR123456\",\"description\":\"bla bla bla\",\"demo_url\":null,\"project_category_id\":null,\"client_id\":null,\"company_id\":null,\"staffs\":\"8,\",\"budget\":0,\"timer_status\":0,\"timer_starting_timestamp\":null,\"total_time_spent\":0,\"progress_status\":null,\"timestamp_start\":\"1517533500\",\"timestamp_end\":\"1517534400\",\"project_status\":1,\"project_note\":null,\"institution_id\":12,\"project_state\":1,\"strata_manager\":5,\"site_contact\":7,\"place_of_service\":0}]\n";

ArrayList<MyDTO> myArray = new ArrayList<>();
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    parseData(data);
}

private void parseData(String response) {


    try {
        JSONArray jsonArray=new JSONArray(response);
        for (int i=0;i<jsonArray.length();i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            MyDTO myDTO = new MyDTO();
            myDTO.setProjectId(Integer.parseInt(jsonObject.getString("project_id")));
            myDTO.setProjectDate(  jsonObject.getString("date"));
            myDTO.setProjectCode(jsonObject.getString("project_code"));
            myDTO.setTitle(jsonObject.getString("title"));

            myArray.add(myDTO);


        }

    }catch (JSONException je){

    }
}
}