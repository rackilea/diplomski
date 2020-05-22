for (String print:words){
    if (print != null) {
        System.out.println(print);
    } else {
        break; // once you encountered the first null, there's no point to continue the loop
    }
}