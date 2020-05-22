public class TestActivity extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_test);

            Gson gson = new Gson();

            try{

                Data data = gson.fromJson(TestJSON.TEST_JSON_2,Data.class);

                List<Member> mensList = data.getOutput().getGolfCourseTee().getMen();
                List<Member> ladiesList = data.getOutput().getGolfCourseTee().getLadies();
                List<Member> juniorsList = data.getOutput().getGolfCourseTee().getJunior();
                List<Member> cumulativeList = data.getOutput().getGolfCourseTee().getAllMembers();

                for(Member member : mensList)
                    Log.v("men","Id: " + member.getTee_id() + " name: " + member.getTee_name() + " color: " + member.getTee_color());

                for(Member member : ladiesList)
                    Log.v("ladies","Id: " + member.getTee_id() + " name: " + member.getTee_name() + " color: " + member.getTee_color());

                for(Member member : juniorsList)
                    Log.v("juniors","Id: " + member.getTee_id() + " name: " + member.getTee_name() + " color: " + member.getTee_color());

                for(Member member : cumulativeList){
                    Log.v("member","Id: " + member.getTee_id() + " name: " + member.getTee_name() + " color: " + member.getTee_color());
                }

            }catch(Exception exception){
                exception.printStackTrace();
            }
        }
    }