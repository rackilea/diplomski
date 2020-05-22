String str = "books/eh/grayL88/WilliamsMC88:::M. Howard Williams::" + 
             "P. A. Massey::Jim A. Crammond:::Benchmarking Prolog for " + 
             "Database Applications.";

String[] arr = str.split(":::");
String[] innerArr = arr[1].split("::");

for (String name: innerArr) {
    System.out.println(name + " -- " + arr[2]);
}