public static void main(String[] args) {
        String input = ScannerUtils.scanForString();
        StringBuilder digitBuilder = new StringBuilder();
        StringBuilder charBuilder = new StringBuilder();
        for(int i = 0; i< input.length(); i++){
            if(input.charAt(i) >= '0' && input.charAt(i) <= '9'){
                digitBuilder.append(input.charAt(i));
            }
            else {
                charBuilder.append(input.charAt(i));
            }
        }
        String output = charBuilder.toString().concat(digitBuilder.toString());
        System.out.println(output);
    }