Long[] samples = new Long[101];

while(input.hasNextLine()){
    try{
      samples[Math.max(0, Math.min(100, Integer.parseInt(input.nextLine())))];
    } catch (ParseException e){/*not a number*/}
}