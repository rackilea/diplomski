class stringProject {
    //this method should be static in order to be used in other static methods like main
    static String concat(String str1, String str2) {
        //naive implementation
        return str1.concat(str2);
    }

    public static void main(String[] args) {
        //your current code here...
        //since you have defined a concat method, you can use it with no problems
        System.out.println(concat(projectStrings.get(1), projectStrings.get(0)));
    }
}