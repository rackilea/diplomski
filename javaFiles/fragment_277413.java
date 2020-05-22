public UserInfoManager() {
        System.out.println(UserInfoManager.class
                .getResource("/milkiv/mytestproject/models/UserInfo.hbm.xml"));

        System.out.println(ClassLoader.getSystemClassLoader().getResource(
                "milkiv/mytestproject/models/UserInfo.hbm.xml"));
}