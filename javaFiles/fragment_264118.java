public class GsonClass {

/**
 * UserID : 
 * Data1 : {"Data1_1":[{"name":"name1","test":"test2"},{"name":"name2","test":"test2"}],"Data1_2":{"Data1_2_1":[{"addr":"addr1","phone":"phone1"},{"addr":"addr2","phone":"phone2"}],"Data1_2_2":[{"country":"country1","sex":"M"},{"country":"country1","sex":"F"}]}}
 */

private String UserID;
private Data1Bean Data1;

public String getUserID() {
    return UserID;
}

public void setUserID(String UserID) {
    this.UserID = UserID;
}

public Data1Bean getData1() {
    return Data1;
}

public void setData1(Data1Bean Data1) {
    this.Data1 = Data1;
}

public static class Data1Bean {
    /**
     * Data1_1 : [{"name":"name1","test":"test2"},{"name":"name2","test":"test2"}]
     * Data1_2 : {"Data1_2_1":[{"addr":"addr1","phone":"phone1"},{"addr":"addr2","phone":"phone2"}],"Data1_2_2":[{"country":"country1","sex":"M"},{"country":"country1","sex":"F"}]}
     */

    private Data12Bean Data1_2;
    private List<Data11Bean> Data1_1;

    public Data12Bean getData1_2() {
        return Data1_2;
    }

    public void setData1_2(Data12Bean Data1_2) {
        this.Data1_2 = Data1_2;
    }

    public List<Data11Bean> getData1_1() {
        return Data1_1;
    }

    public void setData1_1(List<Data11Bean> Data1_1) {
        this.Data1_1 = Data1_1;
    }

    public static class Data12Bean {
        private List<Data121Bean> Data1_2_1;
        private List<Data122Bean> Data1_2_2;

        public List<Data121Bean> getData1_2_1() {
            return Data1_2_1;
        }

        public void setData1_2_1(List<Data121Bean> Data1_2_1) {
            this.Data1_2_1 = Data1_2_1;
        }

        public List<Data122Bean> getData1_2_2() {
            return Data1_2_2;
        }

        public void setData1_2_2(List<Data122Bean> Data1_2_2) {
            this.Data1_2_2 = Data1_2_2;
        }

        public static class Data121Bean {
            /**
             * addr : addr1
             * phone : phone1
             */

            private String addr;
            private String phone;

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }
        }

        public static class Data122Bean {
            /**
             * country : country1
             * sex : M
             */

            private String country;
            private String sex;

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }
        }
    }

    public static class Data11Bean {
        /**
         * name : name1
         * test : test2
         */

        private String name;
        private String test;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTest() {
            return test;
        }

        public void setTest(String test) {
            this.test = test;
        }
    }
}
}