class Main {
    public static void main(String[] args) {
        System.out.println(UserInfo.GetAge());
    }

    static class UserInfo {
        public String Name = "Example Name";
        static int Age = 13;
        static int GetAge() {
            return (Age);
        }
    }
}