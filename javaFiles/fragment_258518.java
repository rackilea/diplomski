class Main {
    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo("John", 13);
        System.out.println(String.format("Name: %s Age: %s", userInfo.getName(), userInfo.getAge()));
    }

    static class UserInfo {
        String name;
        int age;

        UserInfo(String name, int age){
            this.name = name;
            this.age = age;
        }

        int getAge() {
            return age;
        }

        String getName() {
            return name;
        }
    }
}