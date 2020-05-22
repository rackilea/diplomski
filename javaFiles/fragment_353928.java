final static String str = "{name ={uri=/book/bookItem3(852)/header}}";

public static void main (String[] args) {

    String value = str.substring((str.indexOf("uri=/") + "uri=/".length()), str.indexOf("}"));
    System.out.println(value);
}