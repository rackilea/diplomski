String s = "::a:b?:c??::d???????:e::";
Pattern pattern = Pattern.compile("(?>\\?.|[^:?])+|(?<=:)(?=:)");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    System.out.println("'" + matcher.group() + "'"); 
}