public static void main(String[] args) {
    String input = "Failed to handle request regression_4828 HISTORIC_TIME from=s:33901510 tn:27825741 bd:false st:Winifred~Dr to=s:-1 d:false f:-1.0 x:-73.92752 y:40.696857 r:-1.0 cd:-1.0 fn:-1 tn:-1 bd:true 1 null false null on subject RoutingRequest";
    final String answer = input.replaceAll("regression_.* (?=on subject)", "_ ");
    System.out.println(answer);
    String expected = "Failed to handle request _ on subject RoutingRequest";
    System.out.println(answer.equals(expected));
}