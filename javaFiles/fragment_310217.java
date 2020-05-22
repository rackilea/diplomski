class StringSplitExample {
        public static void main(String[] args) {
                String st = "Hello_World";
                String str[] = st.split("_");
                for (int i = 0; i < str.length; i++) {
                        System.out.println(str[i]);
                }
        }
}