int lineNo = 0;

while((nums = br.readLine()) != null){

        String numbers[] = nums.split(" "); // hoping you have space sepearated 3 double values in a line
        length[lineNo] = Double.parseDouble(numbers[0]);
        width[lineNo] = Double.parseDouble(numbers[1]);
        height[lineNo] = Double.parseDouble(numbers[2]);
        lineNo++;

}