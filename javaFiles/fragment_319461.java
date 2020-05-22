public class Data {

        @SerializedName("output")
        Output output;

        public Output getOutput() {return output;}
    }

    public class Output {

        @SerializedName("status")
        String status;

        @SerializedName("GolfCourseTee")
        GolfCourseTee GolfCourseTee;

        @SerializedName("message")
        String message;

        public com.pearson.android.test.GolfCourseTee getGolfCourseTee() {return GolfCourseTee;}

        public String getMessage() {return message;}

        public String getStatus() {return status;}
    }

    public class GolfCourseTee {

        @SerializedName("Men")
        List<Member> Men;

        @SerializedName("Ladies")
        List<Member> Ladies;

        @SerializedName("Junior")
        List<Member> Junior;

        List<Member> cumulativeList;

        public List<Member> getAllMembers(){

            if(cumulativeList == null){  
                cumulativeList = new ArrayList<Member>();
                cumulativeList.addAll(Men);
                cumulativeList.addAll(Ladies);
                cumulativeList.addAll(Junior);
            }
            return cumulativeList;
        }

        public List<Member> getJunior() {return Junior;}

        public List<Member> getLadies() {return Ladies;}

        public List<Member> getMen() {return Men;}
    }

    public class Member {

        @SerializedName("tee_id")
        int tee_id;

        @SerializedName("tee_name")
        String tee_name;

        @SerializedName("tee_color")
        String tee_color;

        public int getTee_id() {return tee_id;}

        public String getTee_color() {return tee_color;}

        public String getTee_name() {return tee_name;}
    }