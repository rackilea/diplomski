public static void main(String[] args) {

        int lv_cnt;
        int lv_num01;
        int lv_num02;

        List<User> userList = new ArrayList<User>();
        lv_cnt = 0;
        lv_num01 = 0;
        lv_num02 = 0;

        while (lv_cnt != 3) {
            lv_num01 = lv_num01 + 1;
            lv_num02 = lv_num02 + 5;
            userList.add(new User(lv_num01, lv_num02));
            lv_cnt = lv_cnt + 1;
        }
        System.out.println(userList.get(0).getIdno());
        System.out.println(userList.get(1).getIdno());
        System.out.println(userList.get(2).getIdno());

        // how do I retrieve data from the second userList.add?

    }

}

class User {

    private int idno;
    private int rela;

    public User(int idno, int rela) {

        this.idno = idno;
        this.rela = rela;

    }

    public int getIdno() {
        return idno;
    }

}